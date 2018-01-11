package com.example.bookingdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Booking controller
 */
@RestController
public class BookingController {
    private List<HotelBooking> bookings;

    public BookingController() {
        this.bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Mariott", 200.5, 3));
        bookings.add(new HotelBooking("Ibis", 90.5, 4));
        bookings.add(new HotelBooking("Novotel", 150.2, 2));

    }

    /**
     * get all bookings
     * @return list of all bookings in json format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getALL(){
        return this.bookings;
    }
}
