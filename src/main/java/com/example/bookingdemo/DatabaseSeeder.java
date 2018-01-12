package com.example.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Add data to our databaase
 */
@Component
public class DatabaseSeeder implements CommandLineRunner {
    private BookingRepository bookingRepository;

    /**
     * Dependency injection
     * @param bookingRepository
     */
    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }


    @Override
    public void run(String... strings) throws Exception {
        List<HotelBooking> bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Mariott", 190.5, 3));
        bookings.add(new HotelBooking("Ibis", 90.2, 4));
        bookings.add(new HotelBooking("Novotel", 130.4, 2));

        bookingRepository.save(bookings);
    }
}
