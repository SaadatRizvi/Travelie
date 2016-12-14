package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.TicketDAO;
import com.travelie.entity.Booking;
import com.travelie.entity.Customer;
import com.travelie.entity.Ticket;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketDAO ticketDAO;
	
	
	
	@Override
	@Transactional
	public List<Ticket> getTickets() {
		
		
		return ticketDAO.getTickets();
	}



	@Override
	@Transactional
	public void saveTicket(Ticket theTicket) {
		
		ticketDAO.saveTicket(theTicket);
		
	}



	@Override
	@Transactional
	public Ticket getTicket(int theId) {
		return ticketDAO.getTicket(theId);
	}



	@Override
	@Transactional
	public void deleteTicket(int theId) {
		ticketDAO.deleteTicket(theId);
		
	}



	@Override
	@Transactional
	public List<Customer> getCustomersBooking(int bId) {
		
		return	ticketDAO.getCustomersBooking(bId);
		
		
	}



	/*@Override
	@Transactional
	public List<Ticket> getTicketfromBooking(int bId, int cId) {
		return ticketDAO.getTicketfromBooking(bId,cId);
		
	}*/

}
