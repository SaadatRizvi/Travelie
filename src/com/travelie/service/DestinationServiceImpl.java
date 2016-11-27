package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.DestinationDAO;
import com.travelie.entity.Destination;

@Service
public class DestinationServiceImpl implements DestinationService {

	@Autowired
	private DestinationDAO destinationDAO;
	
	
	
	@Override
	@Transactional
	public List<Destination> getDestinations() {
		
		
		return destinationDAO.getDestinations();
	}



	@Override
	@Transactional
	public void saveDestination(Destination theDestination) {
		
		destinationDAO.saveDestination(theDestination);
		
	}



	@Override
	@Transactional
	public Destination getDestination(int theId) {
		return destinationDAO.getDestination(theId);
	}



	@Override
	@Transactional
	public void deleteDestination(int theId) {
		destinationDAO.deleteDestination(theId);
		
	}

}
