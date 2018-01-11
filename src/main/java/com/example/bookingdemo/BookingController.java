package com.example.bookingdemo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Booking controller
 */
@RestController
@RequestMapping(value="/bookings")
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

    /**
     * get bookings with affordable price
     * @return list of bookings with affordable price in json format
     */
    @RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return this.bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
    }
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking booking) {
        this.bookings.add(booking);
        return this.bookings;
    }
}
