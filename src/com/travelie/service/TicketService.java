package com.travelie.service;

import java.util.List;

import com.travelie.entity.Ticket;

public interface TicketService {

	
	public List<Ticket> getTickets();

	public void saveTicket(Ticket theTicket);

	public Ticket getTicket(int theId);

	public void deleteTicket(int theId);


	
}
