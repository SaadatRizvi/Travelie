package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Ticket;

public interface TicketDAO {

	public List<Ticket> getTickets();

	public void saveTicket(Ticket theTicket);

	public Ticket getTicket(int theId);

	public void deleteTicket(int theId);
	
}
