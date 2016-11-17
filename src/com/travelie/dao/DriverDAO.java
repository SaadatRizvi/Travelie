package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Driver;

public interface DriverDAO {

	public List<Driver> getDrivers();

	public void saveDriver(Driver theDriver);

	public Driver getDriver(int theId);

	public void deleteDriver(int theId);
	
}