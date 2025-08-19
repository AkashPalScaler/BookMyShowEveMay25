package com.scaler.BookMyShow2.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel{
        @ManyToOne
        private  Booking booking;
        private String transactionId;
        private Double amount;
        @Enumerated(EnumType.ORDINAL)
        private PaymentStatus status;
        @Enumerated(EnumType.ORDINAL)
        private PaymentMode paymentMode;
        @Enumerated(EnumType.ORDINAL)
        private PaymentGateway gateway;
}
// Paymenttable - id | booking_id