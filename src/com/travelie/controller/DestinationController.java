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

import com.travelie.entity.Destination;
import com.travelie.entity.Van;
import com.travelie.entity.VanType;
import com.travelie.service.DestinationService;

@Controller
@RequestMapping(value = "/destination")
public class DestinationController {
	
	
	@Autowired
	DestinationService destinationService;
	
@GetMapping("/list")
public String listDestinations(Model model){
	
	List<Destination> destinations = destinationService.getDestinations();
	
	model.addAttribute("destinations", destinations);
	
	return "list-destinations";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	Destination theDestination = new Destination();
	
	theModel.addAttribute("destination", theDestination);
	
	
	return "destination-form";
}

@PostMapping("/saveDestination")
public String saveDestination(@ModelAttribute("destination") Destination theDestination){
	
	
	boolean errors = false;


	 List<Destination> destinations = destinationService.getDestinations();

		boolean isValidRegistration = true;
		
		
		for (Destination destinationTemp : destinations){
			
			if (theDestination.getLocation().equals(destinationTemp.getLocation())){
				isValidRegistration = false;break;
			}
			
		}
		
		if (!isValidRegistration){
			theDestination.setLocation("Please enter a Unique Destination");
		
						errors = true;
		}
					
			
			if (errors){
				
				return "destination-form";
			}
	
	destinationService.saveDestination(theDestination);
	
	
	
	return "redirect:/destination/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("destinationId") int theId, Model theModel){
	
	Destination theDestination = destinationService.getDestination(theId);
	
	theModel.addAttribute("destination", theDestination);
	
	return "destination-form";
	
	
}

@GetMapping("/delete")
public String deleteDestination(@RequestParam("destinationId") int theId){
	 destinationService.deleteDestination(theId);
	
	 return "redirect:/destination/list";
	



}

}
