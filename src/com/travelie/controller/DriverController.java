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

import com.travelie.entity.Driver;
import com.travelie.entity.Van;
import com.travelie.entity.VanType;
import com.travelie.service.DriverService;

@Controller
@RequestMapping(value = "/driver")
public class DriverController {
	
	boolean isUpdate = false;
	
	@Autowired
	DriverService driverService;
	
@GetMapping("/list")
public String listDrivers(Model model){
	
	List<Driver> drivers = driverService.getDrivers();
	
	model.addAttribute("drivers", drivers);
	
	return "list-drivers";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	isUpdate = false;
	
	Driver theDriver = new Driver();
	
	theModel.addAttribute("driver", theDriver);
	
	
	return "driver-form";
}

@PostMapping("/saveDriver")
public String saveDriver(@ModelAttribute("driver") Driver theDriver){
	
	
	boolean errors = false;


	 List<Driver> drivers = driverService.getDrivers();
	 	
	 	
	 	// Check for CNIC 
		boolean isValidRegistration = true;
		 
		for (Driver driverTemp : drivers){
			
			if ( !( isUpdate && theDriver.getId() == driverTemp.getId() ) ){
				if (theDriver.getCnic().equals(driverTemp.getCnic())){
					isValidRegistration = false;break;
				}
			}
		}
		if ( theDriver.getCnic().equals("Please enter a Unique CNIC") || theDriver.getCnic().equals("Please enter a Valid CNIC") ){
			theDriver.setCnic("Please enter a Valid CNIC");
			
			errors = true;
		}
		if (!isValidRegistration){
			theDriver.setCnic("Please enter a Unique CNIC");
		
			errors = true;
		}
		
		
		// Check for License Number 
		isValidRegistration = true;
		
		for (Driver driverTemp : drivers){
			
			if ( !( isUpdate && theDriver.getId() == driverTemp.getId() ) ){
				if (theDriver.getLicenseNumber().equals(driverTemp.getLicenseNumber())){
					isValidRegistration = false;break;
				}
			}
		}
		if ( theDriver.getLicenseNumber().equals("Please enter a Unique License#") || theDriver.getLicenseNumber().equals("Please enter a Valid License#") ){
			theDriver.setLicenseNumber("Please enter a Valid License#");
			
			errors = true;
		}
		if (!isValidRegistration){
			theDriver.setLicenseNumber("Please enter a Unique License#");
		
			errors = true;
		}
		
		
		// Check for Phone Number 
		isValidRegistration = true;
		
		for (Driver driverTemp : drivers){
			
			if ( !( isUpdate && theDriver.getId() == driverTemp.getId() ) ){
				if (theDriver.getPhoneNumber() == driverTemp.getPhoneNumber() ){
					isValidRegistration = false;break;
				}
			}
		}
		if (!isValidRegistration || theDriver.getPhoneNumber() < 1){
			theDriver.setPhoneNumber(-1);
		
			errors = true;
		}
		
		
		// Check for Picture 
		isValidRegistration = true;
		
		for (Driver driverTemp : drivers){
			
			if ( !( isUpdate && theDriver.getId() == driverTemp.getId() ) ){
				if (theDriver.getPicture().equals(driverTemp.getPicture())){
					isValidRegistration = false;break;
				}
			}
		}
		if ( theDriver.getPicture().equals("Please enter a Unique Picture Location") || theDriver.getPicture().equals("Please enter a Valid Picture Location") ){
			theDriver.setPicture("Please enter a Valid Picture Location");
			
			errors = true;
		}
		if (!isValidRegistration){
			theDriver.setPicture("Please enter a Unique Picture Location");
		
			errors = true;
		}
		
		// Empty Field Checks
		//First Name
		if ( theDriver.getFirstName().equals("") || theDriver.getFirstName().equals("Please Enter Valid First Name") ){
			theDriver.setFirstName("Please Enter Valid First Name");
			errors = true;
		}
		//Last Name
		if ( theDriver.getLastName().equals("") || theDriver.getLastName().equals("Please Enter Valid Last Name") ){
			theDriver.setLastName("Please Enter Valid Last Name");
			errors = true;
		}
		//CNIC
		if ( theDriver.getCnic().equals("") || theDriver.getCnic().equals("Please Enter Valid CNIC") ){
			theDriver.setCnic("Please Enter Valid CNIC");
			errors = true;
		}
		//License Number
		if ( theDriver.getLicenseNumber().equals("") || theDriver.getLicenseNumber().equals("Please enter a Valid License#") ){
			theDriver.setLicenseNumber("Please enter a Valid License#");
			errors = true;
		}
		//Picture
		if ( theDriver.getPicture().equals("") || theDriver.getPicture().equals("Please enter a Valid Picture Location") ){
			theDriver.setPicture("Please enter a Valid Picture Location");
			errors = true;
		}
		
			
		if (errors){
				
			return "driver-form";
		}
	
	driverService.saveDriver(theDriver);
	
	
	
	return "redirect:/driver/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("driverId") int theId, Model theModel){
	
	isUpdate = true;
	
	Driver theDriver = driverService.getDriver(theId);
	
	theModel.addAttribute("driver", theDriver);
	
	return "driver-form";
	
	
}

@GetMapping("/delete")
public String deleteDriver(@RequestParam("driverId") int theId){
	 driverService.deleteDriver(theId);
	
	 return "redirect:/driver/list";
	



}

}
