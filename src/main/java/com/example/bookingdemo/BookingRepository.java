package com.example.bookingdemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Create an HotelBooking repository
 */
@Repository
public interface BookingRepository extends JpaRepository<HotelBooking, Long> {
    /**
     * method that find bookings with price less than added. We don't need to implement
     * this method. JPA repository do it automatically
     * @param price price that user input
     * @return bookings with price less than
     */
    List<HotelBooking> findByPricePerNightLessThan(double price);
}
