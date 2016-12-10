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

import com.travelie.entity.Customer;
import com.travelie.entity.Van;
import com.travelie.service.CustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
@GetMapping("/list")
public String listCustomers(Model model){
	
	List<Customer> customers = customerService.getCustomers();
	
	model.addAttribute("customers", customers);
	
	return "list-customers";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	Customer theCustomer = new Customer();
	
	theModel.addAttribute("customer", theCustomer);
	
	
	return "customer-form";
}

@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
	
	
	boolean errors = false;


	 List<Customer> customers = customerService.getCustomers();

		boolean isValidRegistration = true;
		
		
		for (Customer customerTemp : customers){
			
			if (theCustomer.getRegNumber() == customerTemp.getRegNumber()){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theCustomer.setRegNumber(999999999);
		
						errors = true;
		}
		if (errors){
			
			return "customer-form";
		}
	
	customerService.saveCustomer(theCustomer);
	
	
	
	return "redirect:/customer/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("customerId") int theId, Model theModel){
	
	Customer theCustomer = customerService.getCustomer(theId);
	
	theModel.addAttribute("customer", theCustomer);
	
	return "customer-form";
	
	
}

@GetMapping("/delete")
public String deleteCustomer(@RequestParam("customerId") int theId){
	 customerService.deleteCustomer(theId);
	
	 return "redirect:/customer/list";
	



}

}
