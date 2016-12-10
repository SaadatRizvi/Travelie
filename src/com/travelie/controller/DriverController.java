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
	
	Driver theDriver = new Driver();
	
	theModel.addAttribute("driver", theDriver);
	
	
	return "driver-form";
}

@PostMapping("/saveDriver")
public String saveDriver(@ModelAttribute("driver") Driver theDriver){
	
	
	boolean errors = false;


	 List<Driver> drivers = driverService.getDrivers();

		boolean isValidRegistration = true;
		
		
		for (Driver driverTemp : drivers){
			
			if (theDriver.getCnic().equals(driverTemp.getCnic())){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theDriver.setCnic("Please enter a Unique CNIC");
		
						errors = true;
		}
		
		
		isValidRegistration = true;
		
		for (Driver driverTemp : drivers){
			
			if (theDriver.getLicenseNumber().equals(driverTemp.getLicenseNumber())){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theDriver.setLicenseNumber("Please enter a Unique License#");
		
						errors = true;
		}
		
		
		isValidRegistration = true;
		
		for (Driver driverTemp : drivers){
			
			if (theDriver.getPhoneNumber() == driverTemp.getPhoneNumber() ){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theDriver.setPhoneNumber(999999999);
		
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
