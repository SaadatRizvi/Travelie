package com.travelie.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.travelie.entity.Customer;
import com.travelie.entity.Destination;
import com.travelie.entity.VanType;
import com.travelie.entity.Webdata;
import com.travelie.service.DestinationService;
import com.travelie.service.VanTypeService;
import com.travelie.service.WebdataService;

@Controller
@RequestMapping(value = "/")
@SessionAttributes(value = { "destinationList",
"newWebdata" })
public class HomepageController {
	
	@Autowired
	WebdataService webdataService;
	
	@Autowired
	VanTypeService vanTypeService;
	
	@Autowired
	DestinationService destinationService;

	
	@RequestMapping("homepage")
	public String showHomepage(Model model){
List<Webdata> webdatas = webdataService.getWebdatas();
		
		model.addAttribute("webdatas", webdatas);
		
		return "index";
		
		
	}
	
	@ModelAttribute(value = "destinationList")
	public List<String> listDestinations() {
	//	logger.info("listDestinations() method: Getting list of destinations");
		List<Destination> listDestination= destinationService.getDestinations();
		
		List<String> listLocation = new ArrayList<String>();
		for(Destination a : listDestination){
			listLocation.add(a.getLocation());	
		}
		
		return listLocation;
		
	}
	
	@ModelAttribute(value = "vanTypeList")
	public List<VanType> listVanType() {
	//	logger.info("listDestinations() method: Getting list of destinations");
		List<VanType> listVanType= vanTypeService.getVanTypes();
		
		List<String> listType = new ArrayList<String>();
		for(VanType a : listVanType){
			listType.add(a.getType());	
		}
		
		return listVanType;
		
	}
	
	
	
	@ModelAttribute(value = "newWebdata")
	public Webdata getNewWebdata() {
		Webdata webdata = new Webdata();
		webdata.setDestination("Destination");
	//	logger.info("getNewWebdata() method: Returning a new instance of Webdata");
		return webdata;
	}
	
	
	
}
