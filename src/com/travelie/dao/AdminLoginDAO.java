package com.travelie.dao;

import java.util.List;

import com.travelie.entity.AdminLogin;

public interface AdminLoginDAO {

	public List<AdminLogin> getAdminLogins();

	public void saveAdminLogin(AdminLogin theAdminLogin);

	public AdminLogin getAdminLogin(int theId);

	public void deleteAdminLogin(int theId);
	
}
