package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Driver;


@Repository
@Transactional
// change Query in every DAO implementation
public class DriverDAOImpl implements DriverDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Driver> getDrivers() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Driver> theQuery =
				currentSession.createQuery("from Driver order by id", Driver.class);
		
		List<Driver> Drivers = theQuery.getResultList();
		
		return Drivers;
	}


	@Override
	public void saveDriver(Driver theDriver) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theDriver);
		
		
		
	}


	@Override
	public Driver getDriver(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Driver theDriver = currentSession.get(Driver.class, theId);
		
		
		return theDriver;
	}


	@Override
	public void deleteDriver(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Driver> theQuery =
				currentSession.createQuery("delete from Driver where id=:DriverId");
		theQuery.setParameter("DriverId", theId);
		
		theQuery.executeUpdate();
		
	}

}
