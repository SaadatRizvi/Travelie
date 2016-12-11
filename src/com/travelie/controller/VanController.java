package com.travelie.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.travelie.entity.Van;
import com.travelie.entity.VanType;
import com.travelie.service.VanService;
import com.travelie.service.VanTypeService;



@Controller
@RequestMapping(value = "/van")
public class VanController {
	
	boolean isUpdate = false;
	
	private static Logger logger = Logger
			.getLogger(VanController.class);
	
	@Autowired
	VanService vanService;
	
	@Autowired
	VanTypeService vanTypeService;
	
	
@GetMapping("")
public String listVansRoot(Model model){
	
	List<Van> vans = vanService.getVans();
	
for (Van van : vans){
		
	
		van.setVanTypeCategory(van.getCategory().getType());
	}
	
	model.addAttribute("vans", vans);
	
	return "redirect:/van/list";
	
}
	
	
@GetMapping("/list")
public String listVans(Model model){
	
	List<Van> vans = vanService.getVans();
	
for (Van van : vans){
		
	
		van.setVanTypeCategory(van.getCategory().getType());
	}
	
	model.addAttribute("vans", vans);
	
	return "list-vans";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	isUpdate = false;
	
	Van theVan = new Van();
	
	theModel.addAttribute("van", theVan);
	
	
	return "van-form";
}

@PostMapping("/saveVan")
public String saveVan(@ModelAttribute("van") Van theVan){
	
	
	boolean errors = false;


	 List<Van> vans = vanService.getVans();

	 	
	 	// Check for Vehicle Registration
	 	boolean isValidRegistration = true;
		
		
		for (Van vanTemp : vans){
			
			if ( !( isUpdate && theVan.getId() == vanTemp.getId() ) ){
				if (theVan.getVehicleRegistration().equals(vanTemp.getVehicleRegistration())){
					isValidRegistration = false;break;
				}
			}
		}
		if ( theVan.getVehicleRegistration().equals("Please Enter a Unique VehicleReg #") || theVan.getVehicleRegistration().equals("Please Enter a Valid VehicleReg #") ){
			theVan.setVehicleRegistration("Please Enter a Valid VehicleReg #");
			
			errors = true;
		}
		if (!isValidRegistration){
			theVan.setVehicleRegistration("Please Enter a Unique VehicleReg #");
		
			errors = true;
		}
		
		
	 	// Check for Vehicle Category / Van Type
		List<VanType> vanTypes = vanTypeService.getVanTypes();
		
		boolean isValidCategory = false;
		
		for (VanType vanTypeTemp : vanTypes){
			if (vanTypeTemp.getType().equals(theVan.getVanTypeCategory()) ) {
				theVan.setCategory(vanTypeTemp);
				isValidCategory = true;break;}
				
		}
		if (!isValidCategory ){
				theVan.setVanTypeCategory("Please Enter a Valid Category");
					errors = true;
		}
		
		
		// Empty Field Checks
		//Vehicle Registration
		if ( theVan.getVehicleRegistration().equals("") || theVan.getVehicleRegistration().equals("Please Enter a Valid VehicleReg #") ){
			theVan.setVehicleRegistration("Please Enter a Valid VehicleReg #");
			errors = true;
		}
		//Vehicle Type
		if ( theVan.getVehicleType().equals("") || theVan.getVehicleType().equals("Please Enter a Valid Vehicle Type") ){
			theVan.setVehicleType("Please Enter a Valid Vehicle Type");
			errors = true;
		}
		//Total Seats
		if ( theVan.getTotalSeats() < 1 ){
			theVan.setTotalSeats(-1);
			errors = true;
		}
		//Vehicle Category / Van Type
		if ( theVan.getVanTypeCategory().equals("") || theVan.getVanTypeCategory().equals("Please Enter a Valid Category") ){
			theVan.setVanTypeCategory("Please Enter a Valid Category");
			errors = true;
		}
		
					
		if (errors){
			
			return "van-form";
		}
		

	vanService.saveVan(theVan);
	
	
	
	return "redirect:/van/list";
}



@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("vanId") int theId, Model theModel){
	
	isUpdate = true;
	
	Van theVan = vanService.getVan(theId);
	
	theVan.setVanTypeCategory( theVan.getCategory().getType() );
	
	theModel.addAttribute("van", theVan);
	
	return "van-form";
	
	
}

@GetMapping("/delete")
public String deleteVan(@RequestParam("vanId") int theId){
	 vanService.deleteVan(theId);
	
	 return "redirect:/van/list";
	



}

}
