package com.travelie.dao;

import java.util.List;

import com.travelie.entity.TicketDetail;

public interface TicketDetailDAO {

	public List<TicketDetail> getTicketDetails();

	public void saveTicketDetail(TicketDetail theTicketDetail);

	public TicketDetail getTicketDetail(int theId);

	public void deleteTicketDetail(int theId);
	
}