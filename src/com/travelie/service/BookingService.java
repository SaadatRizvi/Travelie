package com.travelie.service;

import java.util.List;

import com.travelie.entity.Booking;

public interface BookingService {

	
	public List<Booking> getBookings();

	public void saveBooking(Booking theBooking);

	public Booking getBooking(int theId);

	public void deleteBooking(int theId);


	
}
