package com.scaler.BookMyShow2.Repositories;

import com.scaler.BookMyShow2.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
}
