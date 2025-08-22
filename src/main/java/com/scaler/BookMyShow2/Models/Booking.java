package com.scaler.BookMyShow2.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel {
    private String bookingNumber;
    // Booking M:1  User
    @ManyToOne
    private User bookedBy;
    // Booking 1:M ShowSeat
    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> showSeats;
    // Movie, screen, theatre, show, seats - all this can be gotten from a showSeat
    private Double amount;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus status;
}

// 1 | User_id | 100 | SUCCESS - ENUMTYPE STRING
// 1 | User_id | 100 | 0 - ENUMTYPE ORDINAL

// Boooking table - id |


// migration files - scripts - details creation of table or alteration of a table
// Migration timestamps
// create_user_table_1
// alter_user_table_to_add_index_on_column_booking_5
// alter_user_table_*_*_10
// drop_user_table