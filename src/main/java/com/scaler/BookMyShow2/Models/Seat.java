package com.scaler.BookMyShow2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.tool.schema.spi.SchemaValidator;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private Integer row;
    private Integer col;
    private String seatNo;
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.ORDINAL)
    private SeatStatus status;
}
