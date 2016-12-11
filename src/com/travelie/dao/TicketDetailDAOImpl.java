package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.TicketDetail;


@Repository
@Transactional
//change Query in every DAO implementation
public class TicketDetailDAOImpl implements TicketDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<TicketDetail> getTicketDetails() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<TicketDetail> theQuery =
				currentSession.createQuery("from TicketDetail order by id", TicketDetail.class);
		
		List<TicketDetail> ticketDetails = theQuery.getResultList();
		
		return ticketDetails;
	}


	@Override
	public void saveTicketDetail(TicketDetail theTicketDetail) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theTicketDetail);
		
		
		
	}


	@Override
	public TicketDetail getTicketDetail(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		TicketDetail theTicketDetail = currentSession.get(TicketDetail.class, theId);
		
		
		return theTicketDetail;
	}


	@Override
	public void deleteTicketDetail(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<TicketDetail> theQuery =
				currentSession.createQuery("delete from TicketDetail where id=:ticketDetailId");
		theQuery.setParameter("ticketDetailId", theId);
		
		theQuery.executeUpdate();
		
	}

}