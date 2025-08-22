package com.scaler.BookMyShow2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "bms_show")
public class Show extends BaseModel{
    private Date startTime;
    private Date endTime;
    @ManyToOne // Show M:1 Movie
    private Movie movie;
    //Show M:1 Screen
    @ManyToOne
    private Screen screen;
    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeats;
    @OneToMany(mappedBy = "show")
    private List<ShowSeatType> showSeatTypes;
}
