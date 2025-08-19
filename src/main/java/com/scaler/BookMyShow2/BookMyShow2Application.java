package com.scaler.BookMyShow2;

import com.scaler.BookMyShow2.Models.BaseModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShow2Application {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShow2Application.class, args);
	}

}
// ORMs - Object Relation Mapping
// Internally runs complex SQL queries to transact(Insert, delete, read) with database
// These queries are optimised
// Tranforms the data to objects internally
// ORM - hibernate | Spring Data JPA - one more layer of abstraction on top of hibernate
// reducing need for writing code even more