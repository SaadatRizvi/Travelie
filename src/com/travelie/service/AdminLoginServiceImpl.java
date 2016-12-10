package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.AdminLoginDAO;
import com.travelie.entity.AdminLogin;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	private AdminLoginDAO adminLoginDAO;
	
	
	
	@Override
	@Transactional
	public List<AdminLogin> getAdminLogins() {
		
		
		return adminLoginDAO.getAdminLogins();
	}



	@Override
	@Transactional
	public void saveAdminLogin(AdminLogin theAdminLogin) {
		
		adminLoginDAO.saveAdminLogin(theAdminLogin);
		
	}



	@Override
	@Transactional
	public AdminLogin getAdminLogin(int theId) {
		return adminLoginDAO.getAdminLogin(theId);
	}



	@Override
	@Transactional
	public void deleteAdminLogin(int theId) {
		adminLoginDAO.deleteAdminLogin(theId);
		
	}

}
