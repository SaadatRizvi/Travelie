package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.BookingDAO;
import com.travelie.entity.Booking;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDAO bookingDAO;
	
	
	
	@Override
	@Transactional
	public List<Booking> getBookings() {
		
		
		return bookingDAO.getBookings();
	}



	@Override
	@Transactional
	public void saveBooking(Booking theBooking) {
		
		bookingDAO.saveBooking(theBooking);
		
	}



	@Override
	@Transactional
	public Booking getBooking(int theId) {
		return bookingDAO.getBooking(theId);
	}



	@Override
	@Transactional
	public void deleteBooking(int theId) {
		bookingDAO.deleteBooking(theId);
		
	}

}
