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

import com.travelie.entity.Booking;
import com.travelie.entity.Driver;
import com.travelie.entity.Route;
import com.travelie.entity.Van;
import com.travelie.service.BookingService;
import com.travelie.service.DriverService;
import com.travelie.service.RouteService;
import com.travelie.service.VanService;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	VanService vanService;
	
	@Autowired
	DriverService driverService;
	
	@Autowired
	RouteService routeService;
	
@GetMapping("")
public String listBookingsRoot(Model model){
	
	List<Booking> bookings = bookingService.getBookings();
	
	model.addAttribute("bookings", bookings);
	
	return "redirect:/booking/list";
	
}
	
@GetMapping("/list")
public String listBookings(Model model){
	
	List<Booking> bookings = bookingService.getBookings();
	
	model.addAttribute("bookings", bookings);
	
	return "list-bookings";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	Booking theBooking = new Booking();
	
	theModel.addAttribute("booking", theBooking);
	
	
	return "booking-form";
}

@PostMapping("/saveBooking")
public String saveBooking(@ModelAttribute("booking") Booking theBooking){
	
	boolean errors = false;
			
			
			// Check for Van ID
			List<Van> vans = vanService.getVans();
			
			boolean isValid = false;
			
			for (Van vanTemp : vans){
				if (vanTemp.getId() == theBooking.getVan().getId() ) {
					isValid = true;break;
				}
			}
			if (!isValid ){
				Van vanTemp = new Van();
				vanTemp.setId(-1);
				theBooking.setVan(vanTemp);
				errors = true;
			}
			
			
			// Check for Driver ID
			List<Driver> drivers = driverService.getDrivers();
			
			isValid = false;
			
			for (Driver driverTemp : drivers){
				if (driverTemp.getId() == theBooking.getDriver().getId() ) {
					isValid = true;break;
				}
			}
			if (!isValid ){
				Driver driverTemp = new Driver();
				driverTemp.setId(-1);
				theBooking.setDriver(driverTemp);
				errors = true;
			}
			
			
			// Check for Route ID
			List<Route> routes = routeService.getRoutes();
			
			isValid = false;
			
			for (Route routeTemp : routes){
				if (routeTemp.getId() == theBooking.getRoute().getId() ) {
					isValid = true;break;
				}
			}
			if (!isValid ){
				Route routeTemp = new Route();
				routeTemp.setId(-1);
				theBooking.setRoute(routeTemp);
				errors = true;
			}
			
			
			
			// Empty Field Checks
			//Van ID
			if ( theBooking.getVan().getId() < 1 ){
				Van vanTemp = new Van();
				vanTemp.setId(-1);
				theBooking.setVan(vanTemp);
				errors = true;
			}
			//Driver ID
			if ( theBooking.getDriver().getId() < 1 ){
				Driver driverTemp = new Driver();
				driverTemp.setId(-1);
				theBooking.setDriver(driverTemp);
				errors = true;
			}
			//Route ID
			if ( theBooking.getRoute().getId() < 1 ){
				Route routeTemp = new Route();
				routeTemp.setId(-1);
				theBooking.setRoute(routeTemp);
				errors = true;
			}
			//Registered Seats
			if ( theBooking.getRegisteredSeats() < 0 ){
				theBooking.setRegisteredSeats(-1);
				errors = true;
			}
			//Departure Time
			if ( theBooking.getDepartureTime().equals("") || theBooking.getDepartureTime().equals("Please Enter a Valid Departure Time") ){
				theBooking.setDepartureTime("Please Enter a Valid DepartureTime");
				errors = true;
			}
			//Arrival Time
			if ( theBooking.getArrivalTime().equals("") || theBooking.getArrivalTime().equals("Please Enter a Valid Arrival Time") ){
				theBooking.setArrivalTime("Please Enter a Valid ArrivalTime");
				errors = true;
			}
			//Departure Date
			if ( theBooking.getDepartureDate().equals("") || theBooking.getDepartureDate().equals("Please Enter a Valid Departure Date") ){
				theBooking.setDepartureDate("Please Enter a Valid DepartureDate");
				errors = true;
			}
			//Expected Price
			if ( theBooking.getExpectedPrice() < 1 ){
				theBooking.setExpectedPrice(-1);
				errors = true;
			}
			
			
			
			if (errors){
				
				return "booking-form";
			}
	
	
	bookingService.saveBooking(theBooking);
	
	return "redirect:/booking/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("bookingId") int theId, Model theModel){
	
	Booking theBooking = bookingService.getBooking(theId);
	
	theModel.addAttribute("booking", theBooking);
	
	return "booking-form";
	
	
}

@GetMapping("/delete")
public String deleteBooking(@RequestParam("bookingId") int theId){
	 bookingService.deleteBooking(theId);
	
	 return "redirect:/booking/list";
	



}

}
