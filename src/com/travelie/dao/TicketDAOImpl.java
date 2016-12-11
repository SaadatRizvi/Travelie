package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Ticket;


@Repository
@Transactional
//change Query in every DAO implementation
public class TicketDAOImpl implements TicketDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Ticket> getTickets() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Ticket> theQuery =
				currentSession.createQuery("from Ticket order by id", Ticket.class);
		
		List<Ticket> tickets = theQuery.getResultList();
		
		return tickets;
	}


	@Override
	public void saveTicket(Ticket theTicket) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTicket);
		
		
		
	}


	@Override
	public Ticket getTicket(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Ticket theTicket = currentSession.get(Ticket.class, theId);
		
		
		return theTicket;
	}


	@Override
	public void deleteTicket(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Ticket> theQuery =
				currentSession.createQuery("delete from Ticket where id=:ticketId");
		theQuery.setParameter("ticketId", theId);
		
		theQuery.executeUpdate();
		
	}

}
