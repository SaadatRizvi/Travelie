package com.travelie.service;

import java.util.List;

import com.travelie.entity.Driver;
import com.travelie.entity.Van;

public interface DriverService {

	
	public List<Driver> getDrivers();

	public void saveDriver(Driver theDriver);

	public Driver getDriver(int theId);

	public void deleteDriver(int theId);

	public List<Driver> getAvailableDrivers();

	
}
