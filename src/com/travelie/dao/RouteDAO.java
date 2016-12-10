package com.travelie.dao;

import java.util.List;

import com.travelie.entity.Route;

public interface RouteDAO {

	public List<Route> getRoutes();

	public void saveRoute(Route theRoute);

	public Route getRoute(int theId);

	public void deleteRoute(int theId);
	
}
