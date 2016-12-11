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
import com.travelie.service.TicketService;

@Controller
@RequestMapping(value = "/ticket")
public class TicketController {
	
	
	@Autowired
	TicketService ticketService;
	
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
	
	Ticket theTicket = new Ticket();
	
	theModel.addAttribute("ticket", theTicket);
	
	
	return "ticket-form";
}

@PostMapping("/saveTicket")
public String saveTicket(@ModelAttribute("ticket") Ticket theTicket){
	
	ticketService.saveTicket(theTicket);
	
	
	
	return "redirect:/ticket/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("ticketId") int theId, Model theModel){
	
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
