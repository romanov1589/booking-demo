package com.example.bookingdemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Booking model class
 */
@Entity
public class HotelBooking {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private long id;

    private String hotelName;
    private double pricePerNight;
    private int nOfNights;

    public HotelBooking(){}

    public HotelBooking(String hotelName, double pricePerNight, int nOfNights) {
        this.hotelName = hotelName;
        this.pricePerNight = pricePerNight;
        this.nOfNights = nOfNights;
    }

    public String getHotelName() {
        return hotelName;
    }
    public double getPricePerNight() {
        return pricePerNight;
    }
    public int getnOfNights() {
        return nOfNights;
    }
    public double getTotalPrice(){
        return this.pricePerNight * this.nOfNights;
    }

    public long getId() {
        return id;
    }
}
