package com.travelie.service;

import java.util.List;

import com.travelie.entity.Route;

public interface RouteService {

	
	public List<Route> getRoutes();

	public void saveRoute(Route theRoute);

	public Route getRoute(int theId);

	public void deleteRoute(int theId);


	
}
