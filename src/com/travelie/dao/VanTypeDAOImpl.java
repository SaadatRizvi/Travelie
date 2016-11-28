package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.travelie.entity.VanType;


@Repository

// change Query in every DAO implementation
public class VanTypeDAOImpl implements VanTypeDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<VanType> getVanTypes() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<VanType> theQuery =
				currentSession.createQuery("from VanType order by id", VanType.class);
		
		List<VanType> vanTypes = theQuery.getResultList();
		
		return vanTypes;
	}


	@Override
	public void saveVanType(VanType theVanType) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theVanType);
		
		
		
	}


	@Override
	public VanType getVanType(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		VanType theVanType = currentSession.get(VanType.class, theId);
		
		
		return theVanType;
	}


	@Override
	public void deleteVanType(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<VanType> theQuery =
				currentSession.createQuery("delete from VanType where id=:VanTypeId");
		theQuery.setParameter("VanTypeId", theId);
		
		theQuery.executeUpdate();
		
	}

}
