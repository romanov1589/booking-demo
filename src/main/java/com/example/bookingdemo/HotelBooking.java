package com.example.bookingdemo;

/**
 * Booking model class
 */
public class HotelBooking {
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
}
