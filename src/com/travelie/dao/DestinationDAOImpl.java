package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Destination;


@Repository
@Transactional
// change Query in every DAO implementation
public class DestinationDAOImpl implements DestinationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Destination> getDestinations() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Destination> theQuery =
				currentSession.createQuery("from Destination order by id", Destination.class);
		
		List<Destination> destinations = theQuery.getResultList();
		
		return destinations;
	}


	@Override
	public void saveDestination(Destination theDestination) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theDestination);
		
		
		
	}


	@Override
	public Destination getDestination(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Destination theDestination = currentSession.get(Destination.class, theId);
		
		
		return theDestination;
	}


	@Override
	public void deleteDestination(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Destination> theQuery =
				currentSession.createQuery("delete from Destination where id=:DestinationId");
		theQuery.setParameter("DestinationId", theId);
		
		theQuery.executeUpdate();
		
	}

}
