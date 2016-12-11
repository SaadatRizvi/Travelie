package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Booking;


@Repository
@Transactional
//change Query in every DAO implementation
public class BookingDAOImpl implements BookingDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Booking> getBookings() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Booking> theQuery =
				currentSession.createQuery("from Booking order by regNumber", Booking.class);
		
		List<Booking> bookings = theQuery.getResultList();
		
		return bookings;
	}


	@Override
	public void saveBooking(Booking theBooking) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theBooking);
		
		
		
	}


	@Override
	public Booking getBooking(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Booking theBooking = currentSession.get(Booking.class, theId);
		
		
		return theBooking;
	}


	@Override
	public void deleteBooking(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Booking> theQuery =
				currentSession.createQuery("delete from Booking where id=:bookingId");
		theQuery.setParameter("bookingId", theId);
		
		theQuery.executeUpdate();
		
	}

}
