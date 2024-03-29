package com.travelie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.DriverDAO;
import com.travelie.entity.Driver;


@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverDAO DriverDAO;
	
	
	
	@Override
	@Transactional
	public List<Driver> getDrivers() {
		
		
		return DriverDAO.getDrivers();
	}



	@Override
	@Transactional
	public void saveDriver(Driver theDriver) {
		
		DriverDAO.saveDriver(theDriver);
		
	}



	@Override
	@Transactional
	public Driver getDriver(int theId) {
		return DriverDAO.getDriver(theId);
	}



	@Override
	@Transactional
	public void deleteDriver(int theId) {
		DriverDAO.deleteDriver(theId);
		
	}



	@Override
	public List<Driver> getAvailableDrivers() {
        List <Driver> drivers = DriverDAO.getDrivers();
		
		List<Driver> availableDrivers = new ArrayList<Driver>();
		
		for (Driver temp: drivers){
			
			if (temp.getFlagged()==0){
				availableDrivers.add(temp);
			}
		}
		return availableDrivers;
	}
	

}
