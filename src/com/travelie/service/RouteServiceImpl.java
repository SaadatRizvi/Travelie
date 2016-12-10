package com.travelie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.travelie.dao.RouteDAO;
import com.travelie.entity.Route;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDAO routeDAO;
	
	
	
	@Override
	@Transactional
	public List<Route> getRoutes() {
		
		
		return routeDAO.getRoutes();
	}



	@Override
	@Transactional
	public void saveRoute(Route theRoute) {
		
		routeDAO.saveRoute(theRoute);
		
	}



	@Override
	@Transactional
	public Route getRoute(int theId) {
		return routeDAO.getRoute(theId);
	}



	@Override
	@Transactional
	public void deleteRoute(int theId) {
		routeDAO.deleteRoute(theId);
		
	}

}
