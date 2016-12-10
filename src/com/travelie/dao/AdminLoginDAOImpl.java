package com.travelie.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.travelie.entity.AdminLogin;


@Repository
//change Query in every DAO implementation
public class AdminLoginDAOImpl implements AdminLoginDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	
	public List<AdminLogin> getAdminLogins() {
		
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<AdminLogin> theQuery =
				currentSession.createQuery("from AdminLogin order by id", AdminLogin.class);
		
		List<AdminLogin> adminLogins = theQuery.getResultList();
		
		return adminLogins;
	}


	@Override
	public void saveAdminLogin(AdminLogin theAdminLogin) {
     Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theAdminLogin);
		
		
		
	}


	@Override
	public AdminLogin getAdminLogin(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		AdminLogin theAdminLogin = currentSession.get(AdminLogin.class, theId);
		
		
		return theAdminLogin;
	}


	@Override
	public void deleteAdminLogin(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<AdminLogin> theQuery =
				currentSession.createQuery("delete from AdminLogin where id=:adminLoginId");
		theQuery.setParameter("adminLoginId", theId);
		
		theQuery.executeUpdate();
		
	}

}
