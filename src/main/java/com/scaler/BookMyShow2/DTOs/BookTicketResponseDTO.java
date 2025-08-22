package com.scaler.BookMyShow2.DTOs;

import com.scaler.BookMyShow2.Models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookTicketResponseDTO {
    private Long bookingId;
    private Double amount;
    private BookingStatus bookingStatus;
    private String message;
    private ResponseStatus status;
}
