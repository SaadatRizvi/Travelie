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
import com.travelie.service.RouteService;

@Controller
@RequestMapping(value = "/route")
public class RouteController {
	
	
	@Autowired
	RouteService routeService;
	
@GetMapping("/list")
public String listRoutes(Model model){
	
	List<Route> routes = routeService.getRoutes();
	
	model.addAttribute("routes", routes);
	
	return "list-routes";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	Route theRoute = new Route();
	
	theModel.addAttribute("route", theRoute);
	
	
	return "route-form";
}

@PostMapping("/saveRoute")
public String saveRoute(@ModelAttribute("route") Route theRoute){
	
	routeService.saveRoute(theRoute);
	
	
	
	return "redirect:/route/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("routeId") int theId, Model theModel){
	
	Route theRoute = routeService.getRoute(theId);
	
	theModel.addAttribute("route", theRoute);
	
	return "route-form";
	
	
}

@GetMapping("/delete")
public String deleteRoute(@RequestParam("routeId") int theId){
	 routeService.deleteRoute(theId);
	
	 return "redirect:/route/list";
	



}

}
