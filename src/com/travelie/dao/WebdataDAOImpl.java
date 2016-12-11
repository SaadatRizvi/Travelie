package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.entity.Webdata;


@Repository
@Transactional
// change Query in every DAO implementation
public class WebdataDAOImpl implements WebdataDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<Webdata> getWebdatas() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Webdata> theQuery =
				currentSession.createQuery("from Webdata order by id", Webdata.class);
		
		List<Webdata> webdatas = theQuery.getResultList();
		
		return webdatas;
	}


	@Override
	public void saveWebdata(Webdata theWebdata) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theWebdata);
		
		
		
	}


	@Override
	public Webdata getWebdata(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Webdata theWebdata = currentSession.get(Webdata.class, theId);
		
		
		return theWebdata;
	}


	@Override
	public void deleteWebdata(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Webdata> theQuery =
				currentSession.createQuery("delete from Webdata where id=:WebdataId");
		theQuery.setParameter("WebdataId", theId);
		
		theQuery.executeUpdate();
		
	}

}
