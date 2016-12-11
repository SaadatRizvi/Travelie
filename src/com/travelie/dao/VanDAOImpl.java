package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Van;


@Repository
@Transactional
// change Query in every DAO implementation
public class VanDAOImpl implements VanDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Van> getVans() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Van> theQuery =
				currentSession.createQuery("from Van order by id", Van.class);
		
		List<Van> Vans = theQuery.getResultList();
		
		return Vans;
	}


	@Override
	public void saveVan(Van theVan) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theVan);
		
		
		
	}


	@Override
	public Van getVan(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Van theVan = currentSession.get(Van.class, theId);
		
		
		return theVan;
	}


	@Override
	public void deleteVan(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Van> theQuery =
				currentSession.createQuery("delete from Van where id=:VanId");
		theQuery.setParameter("VanId", theId);
		
		theQuery.executeUpdate();
		
	}

}
