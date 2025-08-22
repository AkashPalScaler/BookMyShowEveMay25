package com.scaler.BookMyShow2.Repositories;

import com.scaler.BookMyShow2.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
