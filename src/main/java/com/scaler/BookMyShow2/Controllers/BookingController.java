package com.scaler.BookMyShow2.Controllers;

import com.scaler.BookMyShow2.DTOs.BookTicketRequestDTO;
import com.scaler.BookMyShow2.DTOs.BookTicketResponseDTO;
import com.scaler.BookMyShow2.DTOs.ResponseStatus;
import com.scaler.BookMyShow2.Models.Booking;
import com.scaler.BookMyShow2.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.awt.print.Book;

@Controller
public class BookingController {
    @Autowired
    private BookingService bookingService;
    BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();

        try{
            Booking booking = bookingService.bookTicket(requestDTO.getShowSeatIds(), requestDTO.getShowId(), requestDTO.getUserId());
            responseDTO.setBookingId(booking.getId());
            responseDTO.setBookingStatus(booking.getStatus());
            responseDTO.setAmount(booking.getAmount());
            responseDTO.setMessage("Booking is successful");
            responseDTO.setStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage("Booking process failed");
        }

        return  responseDTO;
    }
}
