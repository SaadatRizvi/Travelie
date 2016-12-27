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

import com.travelie.entity.Ticket;
import com.travelie.entity.Booking;
import com.travelie.entity.Customer;
import com.travelie.service.TicketService;
import com.travelie.service.BookingService;
import com.travelie.service.CustomerService;

@Controller
@RequestMapping(value = "/ticket")
public class TicketController {
	
	boolean isUpdate = false;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	BookingService bookingService;
	
	@Autowired
	CustomerService customerService;
	
@GetMapping("")
public String listTicketsRoute(Model model){
	
	List<Ticket> tickets = ticketService.getTickets();
	
	model.addAttribute("tickets", tickets);
	
	return "redirect:/ticket/list";
	
}
	
@GetMapping("/list")
public String listTickets(Model model){
	
	List<Ticket> tickets = ticketService.getTickets();
	
	model.addAttribute("tickets", tickets);
	
	return "list-tickets";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	isUpdate = false;
	
	Ticket theTicket = new Ticket();
	
	theModel.addAttribute("ticket", theTicket);
	
	
	return "ticket-form";
}

@PostMapping("/saveTicket")
public String saveTicket(@ModelAttribute("ticket") Ticket theTicket){
	
	boolean errors = false;
			
			
			// Check for Booking ID
			List<Booking> bookings = bookingService.getBookings();
			
			boolean isValid = false;
			
			for (Booking bookingTemp : bookings){
				if (bookingTemp.getId() == theTicket.getBooking().getId() ) {
					isValid = true;break;
				}
			}
			if (!isValid ){
				Booking bookingTemp = new Booking();
				bookingTemp.setId(-1);
				theTicket.setBooking(bookingTemp);
				errors = true;
			}
			
			
			// Check for Customer ID
			List<Customer> customers = customerService.getCustomers();
			
			isValid = false;
			
			for (Customer customerTemp : customers){
				if (customerTemp.getId() == theTicket.getCustomer().getId() ) {
					isValid = true;break;
				}
			}
			if (!isValid ){
				Customer customerTemp = new Customer();
				customerTemp.setId(-1);
				theTicket.setCustomer(customerTemp);
				errors = true;
			}
			
			
			// Check for one Seat Number only for one Booking ID
			List<Ticket> tickets = ticketService.getTickets();
			
			isValid = true;
			
			for (Ticket ticketTemp : tickets){
				if ( !( isUpdate && theTicket.getId() == ticketTemp.getId() ) ){
					if ( theTicket.getBooking().getId() == ticketTemp.getBooking().getId() && theTicket.getSeatNumber() == ticketTemp.getSeatNumber() ) {
					isValid = false;break;
					}
				}
			}
			if (!isValid ){
				theTicket.setSeatNumber(-1);
				errors = true;
			}
			
			
			
			// Empty Field Checks
			//Booking ID
			if ( theTicket.getBooking().getId() < 1 ){
				Booking bookingTemp = new Booking();
				bookingTemp.setId(-1);
				theTicket.setBooking(bookingTemp);
				errors = true;
			}
			//Customer ID
			if ( theTicket.getCustomer().getId() < 1 ){
				Customer customerTemp = new Customer();
				customerTemp.setId(-1);
				theTicket.setCustomer(customerTemp);
				errors = true;
			}
			//Seat Number
			if ( theTicket.getSeatNumber() < 1 ){
				theTicket.setSeatNumber(-1);
				errors = true;
			}
			
			
			
			if (errors){
				
				return "ticket-form";
			}
	
	ticketService.saveTicket(theTicket);
	
	
	
	return "redirect:/ticket/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("ticketId") int theId, Model theModel){
	
	isUpdate = true;
	
	Ticket theTicket = ticketService.getTicket(theId);
	
	theModel.addAttribute("ticket", theTicket);
	
	return "ticket-form";
	
	
}

@GetMapping("/delete")
public String deleteTicket(@RequestParam("ticketId") int theId){
	 ticketService.deleteTicket(theId);
	
	 return "redirect:/ticket/list";
	



}

}
