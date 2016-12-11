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
	
	boolean isUpdate = false;
	
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
	
	isUpdate = false;
	
	Customer theCustomer = new Customer();
	
	theModel.addAttribute("customer", theCustomer);
	
	
	return "customer-form";
}

@PostMapping("/saveCustomer")
public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){
	
	
	boolean errors = false;

	 List<Customer> customers = customerService.getCustomers();
	 

		// Check for Reg Number
	 	boolean isValidRegistration = true;
		
		
		for (Customer customerTemp : customers){
			
			if ( !( isUpdate && theCustomer.getId() == customerTemp.getId() ) ){
				if (theCustomer.getRegNumber() == customerTemp.getRegNumber()){
					isValidRegistration = false;break;
				}
			}
			
		}
		
		if (!isValidRegistration || theCustomer.getRegNumber() < 1){
			theCustomer.setRegNumber(-1);
		
						errors = true;
		}

		
		// Check for Phone Number
		isValidRegistration = true;
		
		for (Customer customerTemp : customers){
			
			if ( !( isUpdate && theCustomer.getId() == customerTemp.getId() ) ){
				if (theCustomer.getPhoneNumber() == customerTemp.getPhoneNumber()){
					isValidRegistration = false;break;
				}
			}
			
		}
		
		if (!isValidRegistration || theCustomer.getPhoneNumber() < 1){
			theCustomer.setPhoneNumber(-1);
		
						errors = true;
		}


		// Check for User Name
		isValidRegistration = true;
		
		if (!isUpdate){
		for (Customer customerTemp : customers){
			
			if ( !( isUpdate && theCustomer.getId() == customerTemp.getId() ) ){
				if (theCustomer.getUsername().equals(customerTemp.getUsername()) ){
					isValidRegistration = false;break;
				}
			}
			
		}
		}
		if ( theCustomer.getUsername().equals("Please Enter a Unique User Name") || theCustomer.getUsername().equals("Please Enter Valid User Name") ){
			theCustomer.setUsername("Please Enter Valid User Name");
			
			errors = true;
		}
		if (!isValidRegistration){
			theCustomer.setUsername("Please Enter a Unique User Name");
		
						errors = true;
		}


		// Check for Email
		isValidRegistration = true;
		
		if (!isUpdate){
		for (Customer customerTemp : customers){
			
			if ( !( isUpdate && theCustomer.getId() == customerTemp.getId() ) ){
				if (theCustomer.getEmail().equals(customerTemp.getEmail()) ){
				isValidRegistration = false;break;
				}
			}
			
		}
		}
		if ( theCustomer.getEmail().equals("Please Enter a Unique Email") || theCustomer.getEmail().equals("Please Enter Valid Email") ){
			theCustomer.setEmail("Please Enter Valid Email");
			
			errors = true;
		}
		if (!isValidRegistration){
			theCustomer.setEmail("Please Enter a Unique Email");
		
						errors = true;
		}
		
		
		// Empty Field Checks
		//User Name
		if ( theCustomer.getUsername().equals("") || theCustomer.getUsername().equals("Please Enter Valid User Name") ){
			theCustomer.setUsername("Please Enter Valid User Name");
			errors = true;
		}
		//Password
		if ( theCustomer.getPassword().equals("") || theCustomer.getPassword().equals("Please Enter Valid Password") ){
			theCustomer.setPassword("Please Enter Valid Password");
			errors = true;
		}
		//First Name
		if ( theCustomer.getFirstName().equals("") || theCustomer.getFirstName().equals("Please Enter Valid First Name") ){
			theCustomer.setFirstName("Please Enter Valid First Name");
			errors = true;
		}
		//Last Name
		if ( theCustomer.getLastName().equals("") || theCustomer.getLastName().equals("Please Enter Valid Last Name") ){
			theCustomer.setLastName("Please Enter Valid Last Name");
			errors = true;
		}
		//Email
		if ( theCustomer.getEmail().equals("") || theCustomer.getEmail().equals("Please Enter Valid Email") ){
			theCustomer.setEmail("Please Enter Valid Email");
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
	
	isUpdate = true;
	
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
