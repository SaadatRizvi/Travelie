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
import com.travelie.service.BookingService;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {
	
	
	@Autowired
	BookingService bookingService;
	
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
