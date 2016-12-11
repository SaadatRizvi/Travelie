package com.travelie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelie.entity.Route;
import com.travelie.entity.Van;
import com.travelie.entity.VanType;
import com.travelie.entity.Destination;
import com.travelie.service.DestinationService;
import com.travelie.service.RouteService;

@Controller
@RequestMapping(value = "/route")
public class RouteController {
	
	boolean isUpdate = false;
	
	@Autowired
	RouteService routeService;
	
	@Autowired
	DestinationService destinationService;
	
@GetMapping("/list")
public String listRoutes(Model model){
	
	List<Route> routes = routeService.getRoutes();
	
	for (Route route : routes){
		route.setDestination_location(route.getDestination().getLocation());
	}
	
	model.addAttribute("routes", routes);
	
	return "list-routes";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	isUpdate = false;
	
	Route theRoute = new Route();
	
	theModel.addAttribute("route", theRoute);
	
	
	return "route-form";
}

@PostMapping("/saveRoute")
public String saveRoute(@ModelAttribute("route") Route theRoute){
	
	
	boolean errors = false;
	
	
	if ( theRoute.getSource().equals("Non-Unique Set Source+Destination")){
		theRoute.setSource("Please Enter a Valid Source");
		
		errors = true;
	}
	if ( theRoute.getDestination_location().equals("Non-Unique Set Source+Destination")){
		theRoute.setDestination_location("Please Enter a Valid Destination");
		
		errors = true;
	}


	 List<Route> routes = routeService.getRoutes();
		
		
	 	// Check for Destination
		List<Destination> destinations = destinationService.getDestinations();
		
		boolean isValidCategory = false;
		
		for (Destination destinationTemp : destinations){
			if (destinationTemp.getLocation().equals(theRoute.getDestination_location()) ) {
				theRoute.setDestination(destinationTemp);
				isValidCategory = true;break;}
				
		}
		if (!isValidCategory ){
			theRoute.setDestination_location("Please Enter a Valid Destination");
					errors = true;
		}
		
		
		// Check that the combination of Source and Destination should be unique
		if ( !errors ){
			isValidCategory = true;
			
			for (Route routeTemp : routes){
				if ( !( isUpdate && theRoute.getId() == routeTemp.getId() ) ){
					if ( theRoute.getSource().equals(routeTemp.getSource()) && theRoute.getDestination().getLocation().equals(routeTemp.getDestination().getLocation()) ){
						isValidCategory = false;break;
					}
				}
			}
			if (!isValidCategory){
				theRoute.setSource("Non-Unique Set Source+Destination");
				theRoute.setDestination_location("Non-Unique Set Source+Destination");
				errors = true;
			}
		}
		
		
		// Empty Field Checks
		//Source
		if ( theRoute.getSource().equals("") || theRoute.getSource().equals("Please Enter a Valid Source") ){
			theRoute.setSource("Please Enter a Valid Source");
			errors = true;
		}
		//ExpectedTravelTime
		if ( theRoute.getExpectedTravelTime().equals("") || theRoute.getExpectedTravelTime().equals("Please Enter a Valid Travel Time") ){
			theRoute.setExpectedTravelTime("Please Enter a Valid Travel Time");
			errors = true;
		}
		//EconomyFare
		if ( theRoute.getEconomyFare() < 1 ){
			theRoute.setEconomyFare(-1);
			errors = true;
		}
		//AC Fare
		if ( theRoute.getAcFare() < 1 ){
			theRoute.setAcFare(-1);
			errors = true;
		}
		//State
		if ( theRoute.getState().equals("") || theRoute.getState().equals("Please Enter a Valid State") ){
			theRoute.setState("Please Enter a Valid State");
			errors = true;
		}
		
		
		if (errors){
			
			return "route-form";
		}
	
	routeService.saveRoute(theRoute);
	
	
	
	return "redirect:/route/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("routeId") int theId, Model theModel){
	
	isUpdate = true;
	
	Route theRoute = routeService.getRoute(theId);
	
	theRoute.setDestination_location( theRoute.getDestination().getLocation() );
	
	theModel.addAttribute("route", theRoute);
	
	return "route-form";
	
	
}

@GetMapping("/delete")
public String deleteRoute(@RequestParam("routeId") int theId){
	 routeService.deleteRoute(theId);
	
	 return "redirect:/route/list";
	



}

}
