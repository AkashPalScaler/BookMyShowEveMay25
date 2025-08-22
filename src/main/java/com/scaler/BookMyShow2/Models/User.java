package com.scaler.BookMyShow2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name="bms_user")
public class User extends BaseModel {
    private String name;
    private String number;
    @OneToMany(mappedBy = "bookedBy")
    private List<Booking> booking;
}
