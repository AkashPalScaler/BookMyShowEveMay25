package com.scaler.BookMyShow2.Services;

import com.scaler.BookMyShow2.Models.*;
import com.scaler.BookMyShow2.Repositories.BookingRepository;
import com.scaler.BookMyShow2.Repositories.ShowRepository;
import com.scaler.BookMyShow2.Repositories.ShowSeatRepository;
import com.scaler.BookMyShow2.Repositories.UserRepository;
import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;


    public Booking bookTicket(List<Long>  showSeatIds, Long showId, Long userId){

        // Steps to book tickets

        // 1.Fetch user with userId
        Optional<User> userOptional = userRepository.findById(userId);
        // 2.Check user
        if(userOptional.isEmpty()) throw new RuntimeException("User not found");
        User user = userOptional.get();

        // 3.Fetch show with showId
        Optional<Show> showOptional = showRepository.findById(showId);

        // 4.Validate show
        if(showOptional.isEmpty()) throw new RuntimeException("Show is unavailable");

        // 5. Fetch showSeats and reserve them
        List<ShowSeat> showSeats = reserveSeats(showSeatIds, showOptional.get());

        // c. Calculate the price of the ticket - HW
        // PriceCalculatorService - strategy type to calculate
        // From show - we fetch the list showSeatTypes
        // Then we loop through all my showSeats
        // showSeat -> Seat -> SeatType and add the price according to matched showSeatType
        Double amount = 100.0;

        // d. Create a booking with all necessary details and return
        Booking booking = new Booking();
        booking.setBookedBy(user);
        // UUID GENERATOR/ TOKEN GENERATOR for the booking number
        booking.setBookingNumber("1223");
        booking.setAmount(amount);
        booking.setStatus(BookingStatus.INPROGRESS);
        booking.setShowSeats(showSeats);
        return bookingRepository.save(booking);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> reserveSeats(List<Long> showSeatIds, Show show){
        // --------- TRANSACTION starts here --------------
        // 5.Fetch showSeats with showSeatsId
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        // 6.Check if show seats are valid and available
        for(ShowSeat showSeat : showSeats){
            // Not part of show
            if(!showSeat.getShow().equals(show)){
                throw  new RuntimeException("Show and ShowSeat doesn't match");
            }
            // Unoperational
            if(showSeat.getStatus().equals(ShowSeatStatus.UNOPERATIONAL)){
                throw new RuntimeException("Seats are un-operational");
            }
            // Booked
            if(showSeat.getStatus().equals(ShowSeatStatus.BOOKED)){
                throw new RuntimeException("Seats are already booked");
            }
            // Blocked and if blocked - duration is lesser than 10 mins (max session type)
            if(showSeat.getStatus().equals(ShowSeatStatus.LOCKED)){
                // To calculate duration two timestamp
                Long duration = Duration.between(new Date().toInstant(), showSeat.getLockedAt().toInstant()).toMinutes();
                if(duration < 10){
                    throw new RuntimeException("Seats are unavailable at the moment, please try after sometime!");
                }
            }
            // a. if yes, we block the showSeats - mark them as "LOCKED" and update locked at time
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());

        }
        // b. save these showSeats back to db
        return showSeatRepository.saveAll(showSeats);
        // --------- TRANSACTION stops here ---------------
    }

}
