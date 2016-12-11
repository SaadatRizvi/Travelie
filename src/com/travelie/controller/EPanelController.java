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

import com.travelie.entity.AdminLogin;
import com.travelie.entity.Customer;
import com.travelie.service.AdminLoginService;

@Controller
@RequestMapping(value = "/epanel")
public class EPanelController {
	
	
	private static Logger logger = Logger
			.getLogger(EPanelController.class);
	
	
	@Autowired
	AdminLoginService adminLoginService;
	
@GetMapping("/login")
public String login(Model theModel){
	
	AdminLogin theAdminLogin = new AdminLogin();
	
	theModel.addAttribute("adminLogin", theAdminLogin);
	
	return "admin-login";
	
}

@PostMapping("/authenticate")
public String authenticate(@ModelAttribute("adminLogin") AdminLogin theAdminLogin){
	
	boolean errors = false;

	 List<AdminLogin> adminLogins = adminLoginService.getAdminLogins();

		boolean isValidAuthentication = false;
		
		
		for (AdminLogin adminLoginTemp : adminLogins){
			if ( theAdminLogin.getUserName().equals(adminLoginTemp.getUserName()) ){
				//logger.info("theAdminLogin.getUserName(): " + theAdminLogin.getUserName());
				//logger.info("theAdminLogin.getPassword(): " + theAdminLogin.getPassword());
				if ( theAdminLogin.getPassword().equals("1234") ){
					isValidAuthentication = true;break;
				}
			}
		}
		
		if (!isValidAuthentication){
			errors = true;
		}
		if (errors){
			return "redirect:/epanel/login";
		}
	
	
	return "redirect:/epanel/control";
}

@GetMapping("/control")
public String control(Model theModel){
	
	AdminLogin theAdminLogin = new AdminLogin();
	
	theModel.addAttribute("adminLogin", theAdminLogin);
	
	return "epanel";
}

}
