package com.example.bookingdemo;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Booking controller
 */
@RestController
@RequestMapping(value="/bookings")
@Api(
        name="Hotel Booking API",
        description = "Provides a list of methods that manage hotel booking",
        stage= ApiStage.RC)
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
    @ApiMethod(description = "Get all hotel bookings from the database")
    public List<HotelBooking> getALL(){
        return this.bookingRepository.findAll();
    }

    /**
     * get bookings with affordable price
     * @return list of bookings with affordable price in json format
     */
    @RequestMapping(value="/affordable/{price}", method=RequestMethod.GET)
    @ApiMethod(description = "Get all hotel bookings there is a price per night less than provided value")
    public List<HotelBooking> getAffordable(@ApiPathParam(name="price") @PathVariable double price) {
        return this.bookingRepository.findByPricePerNightLessThan(price);
    }
    @RequestMapping(value="/create", method=RequestMethod.POST)
    @ApiMethod(description = "Create a booking and save it in database")
    public List<HotelBooking> create(@RequestBody HotelBooking booking) {
        bookingRepository.save(booking);
        return bookingRepository.findAll();
    }
    @RequestMapping(value="/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove hotel booking by provided id from the database")
    public List<HotelBooking> remove(@ApiPathParam(name="id") @PathVariable long id){
        this.bookingRepository.delete(id);
        return this.bookingRepository.findAll();
    }
}
