package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Booking;

public interface BookingDAO {

	public List<Booking> getBookings();

	public void saveBooking(Booking theBooking);

	public Booking getBooking(int theId);

	public void deleteBooking(int theId);
	
}
