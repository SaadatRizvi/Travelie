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
	
	
	private static Logger logger = Logger
			.getLogger(VanController.class);
	
	@Autowired
	VanService vanService;
	
	@Autowired
	VanTypeService vanTypeService;
	
	//
	
	
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
	
	Van theVan = new Van();
	
	
	
	theModel.addAttribute("van", theVan);
	
	
	return "van-form";
}

@PostMapping("/saveVan")
public String saveVan(@ModelAttribute("van") Van theVan){
	
	
	boolean errors = false;


	 List<Van> vans = vanService.getVans();

		boolean isValidRegistration = true;
		
		
		for (Van vanTemp : vans){
			
			if (theVan.getVehicleRegistration().equals(vanTemp.getVehicleRegistration())){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theVan.setVehicleRegistration("Please enter a Unique VehicleReg #.");
		
						errors = true;
		}
		
		List<VanType> vanTypes = vanTypeService.getVanTypes();
		
		boolean isValidCategory = false;
		
		
		
		for (VanType vanType : vanTypes){
			if (vanType.getType().equals(theVan.getVanTypeCategory()) ) {
				theVan.setCategory(vanType);
				isValidCategory = true;break;}
				
		}
		if (!isValidCategory ){
				theVan.setVanTypeCategory("Please enter a valid Category.");
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
	
	Van theVan = vanService.getVan(theId);
	
	theModel.addAttribute("van", theVan);
	
	return "van-form";
	
	
}

@GetMapping("/delete")
public String deleteVan(@RequestParam("vanId") int theId){
	 vanService.deleteVan(theId);
	
	 return "redirect:/van/list";
	



}

}
