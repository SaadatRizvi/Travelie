package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Destination;

public interface DestinationDAO {

	public List<Destination> getDestinations();

	public void saveDestination(Destination theDestination);

	public Destination getDestination(int theId);

	public void deleteDestination(int theId);
	
}
