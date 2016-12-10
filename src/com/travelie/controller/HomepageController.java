package com.travelie.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	private static Logger logger = Logger
			.getLogger(HomepageController.class);
	@Autowired
	WebdataService webdataService;
	
	@Autowired
	VanTypeService vanTypeService;
	
	@Autowired
	DestinationService destinationService;
	
	boolean loggedin = false;

	
	@RequestMapping("/homepage")
	public String showHomepage(@ModelAttribute(value = "newWebdata") Webdata webdata,Model model){
List<Webdata> webdatas = webdataService.getWebdatas();
		
		model.addAttribute("webdatas", webdatas);
		
		logger.info("newWebdata: id: "+ webdata.getId());
		logger.info("newWebdata: Type: "+ webdata.getType());
		logger.info("newWebdata: Time: "+ webdata.getDepartureTime());
		logger.info("newWebdata: Date: "+ webdata.getDepartureDate());
		logger.info("newWebdata: Destinaton: "+ webdata.getDestination());
		
		
		
		return "index";
		
		
	}
	
	
	@PostMapping(value = "/homepage", params = "tAction=create")
	public String verifyWebData(@ModelAttribute(value = "newWebdata") Webdata webdata){
		
		if (!loggedin){
			
			// return "login-form";
		}
		
	//	webdataService.saveWebdata(webdata);
		
		
		
		
		
		
		
		return "login-form";
		
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
	public List<String> listVanType() {
	
		List<VanType> listVanType= vanTypeService.getVanTypes();
		
		List<String> listType = new ArrayList<String>();
		for(VanType a : listVanType){
			listType.add(a.getType());	
		}
		logger.info("listDestinations() method: Getting list of destinations");
		return listType;
		
	}
	
	
	
	@ModelAttribute(value = "newWebdata")
	public Webdata getNewWebdata() {
		Webdata webdata = new Webdata();
		webdata.setDestination("Destination");
		logger.info("getNewWebdata() method: Returning a new instance of Webdata");
		return webdata;
	}
	
	
	@InitBinder(value = "newWebdata")
	public void initBinder_newWebData(WebDataBinder webDataBinder){
		
		// Change departureDate in webdata to 'Date' type instead of String for improvement
		
		/*webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(
			new SimpleDateFormat("MM-dd-yyyy"), false));
		*/
		
		webDataBinder.setDisallowedFields("id");
		
	}
	
	
	
}
