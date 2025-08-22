package com.scaler.BookMyShow2;

import com.scaler.BookMyShow2.Controllers.UserController;
import com.scaler.BookMyShow2.DTOs.*;
import com.scaler.BookMyShow2.Models.*;
import com.scaler.BookMyShow2.Models.BaseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BookMyShow2Application implements CommandLineRunner {

	@Autowired
	private UserController userController;

	public void dataGeneration(){

		List<Movie> movies = new ArrayList<>();
		Movie movie1 = new Movie();
		movie1.setName("Kalki");

		Movie movie2 = new Movie();
		movie2.setName("Dunki");

		Movie movie3 = new Movie();
		movie3.setName("Deadpool");

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);

		//Save all the movies
		movieRepository.saveAll(movies);

		SeatType seatType1 = new SeatType();
		seatType1.setType("GOLD");
		SeatType seatType2 = new SeatType();
		seatType2.setType("SILVER");


		List<Theatre> theatres = new ArrayList<>();
		Theatre theatre1 = new Theatre();
		theatre1.setName("Cinemax");
		theatre1.setAddress("Thane");
		theatre1.setMovies(movies);

		List<Seat> seats1 = new ArrayList<>(); //Screen 1
		List<Seat> seats2 = new ArrayList<>(); // Screen 2
		Seat seat1 = new Seat();
		seat1.setName("1A");
		seat1.setSeatType(seatType1);
		Seat seat2 = new Seat();
		seat2.setName("2B");
		seat2.setSeatType(seatType1);

		seats1.add(seat1);
		seats1.add(seat2);

		Seat seat3 = new Seat();
		seat3.setName("1A");
		seat3.setSeatType(seatType1);
		Seat seat4 = new Seat();
		seat4.setName("2B");
		seat4.setSeatType(seatType1);

		seats2.add(seat3);
		seats2.add(seat4);

		Screen screen1 = new Screen();
		screen1.setName("AUDI 1");
		screen1.setTheatre(theatre1);
		screen1.setSeats(seats1);

		Screen screen2 = new Screen();
		screen2.setName("AUDI 2");
		screen2.setTheatre(theatre1);
		screen2.setSeats(seats2);


		Theatre theatre2 = new Theatre();
		theatre2.setName("IMAX");
		theatre2.setAddress("Kolshet Rd");
		theatre2.setMovies(movies);

		List<Seat> seats3 = new ArrayList<>(); // Screen 3
		List<Seat> seats4 = new ArrayList<>(); //Screen 4
		Seat seat31 = new Seat();
		seat31.setName("1A");
		seat31.setSeatType(seatType1);
		Seat seat32 = new Seat();
		seat32.setName("2B");
		seat32.setSeatType(seatType1);

		seats3.add(seat31);
		seats3.add(seat32);

		Seat seat41 = new Seat();
		seat41.setName("1A");
		seat41.setSeatType(seatType1);
		Seat seat42 = new Seat();
		seat42.setName("2B");
		seat42.setSeatType(seatType1);

		seats4.add(seat41);
		seats4.add(seat42);

		Screen screen3 = new Screen();
		screen3.setName("SCREEN 1");
		screen3.setTheatre(theatre2);
		screen3.setSeats(seats3);

		Screen screen4 = new Screen();
		screen4.setName("SCREEN 2");
		screen4.setTheatre(theatre2);
		screen4.setSeats(seats4);

		theatres.add(theatre1);
		theatres.add(theatre2);

		Region region = new Region();
		region.setName("Mumbai");
		region.setTheatres(theatres);

		// Home work : Add all repos
		//Create show for each screen in each theatre
		//Create showSeat for each of those shows
	}

	public static void main(String[] args) {
		SpringApplication.run(BookMyShow2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		SignUpRequestDTO signUpRequestDTO = new SignUpRequestDTO();
//		signUpRequestDTO.setEmail("akash.pal1@gmail.com");
//		signUpRequestDTO.setName("Akash1");
//		signUpRequestDTO.setPassword("passpass");
//
//		userController.signUp(signUpRequestDTO);

		LoginRequestDTO loginRequestDTO = new LoginRequestDTO();
		loginRequestDTO.setEmail("akash.pal@gmail.com");
		loginRequestDTO.setPassword("passpass");

		LoginResponseDTO responseDTO = userController.login(loginRequestDTO);

		if(responseDTO.getStatus().equals(ResponseStatus.SUCCESS)){
			System.out.println("User login successfull");
		}else{
			System.out.println(responseDTO.getMessage());
		}

	}
}
// ORMs - Object Relation Mapping
// Internally runs complex SQL queries to transact(Insert, delete, read) with database
// These queries are optimised
// Tranforms the data to objects internally
// ORM - hibernate | Spring Data JPA - one more layer of abstraction on top of hibernate
// reducing need for writing code even more

// Agenda
// Signup flow
// Login flow
// Booking flow
