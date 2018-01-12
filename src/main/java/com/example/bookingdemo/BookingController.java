package com.example.bookingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Booking controller
 */
@RestController
@RequestMapping(value="/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    /**
     * Dependency injection
     * @param bookingRepository
     */
    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    /**
     * get all bookings
     * @return list of all bookings in json format
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<HotelBooking> getALL(){
        return this.bookingRepository.findAll();
    }

    /**
     * get bookings with affordable price
     * @return list of bookings with affordable price in json format
     */
    @RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price) {
        return this.bookingRepository.findByPricePerNightLessThan(price);
    }
    @RequestMapping(value="/create", method=RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking booking) {
        bookingRepository.save(booking);
        return bookingRepository.findAll();
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public List<HotelBooking> remove(@PathVariable long id){
        this.bookingRepository.delete(id);
        return this.bookingRepository.findAll();
    }
}
