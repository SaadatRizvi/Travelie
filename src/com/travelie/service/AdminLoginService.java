package com.travelie.service;

import java.util.List;

import com.travelie.entity.AdminLogin;

public interface AdminLoginService {

	
	public List<AdminLogin> getAdminLogins();

	public void saveAdminLogin(AdminLogin theAdminLogin);

	public AdminLogin getAdminLogin(int theId);

	public void deleteAdminLogin(int theId);


	
}
