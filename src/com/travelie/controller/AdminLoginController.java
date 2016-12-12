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

import com.travelie.entity.AdminLogin;
import com.travelie.service.AdminLoginService;

@Controller
@RequestMapping(value = "/admin")
public class AdminLoginController {
	
	boolean isUpdate = false;
	
	@Autowired
	AdminLoginService adminLoginService;
	
@GetMapping("")
public String listAdminLoginsRoot(Model model){
	
	List<AdminLogin> adminLogins = adminLoginService.getAdminLogins();
	
	model.addAttribute("adminLogins", adminLogins);
	
	return "redirect:/admin/list";
	
}
	
@GetMapping("/list")
public String listAdminLogins(Model model){
	
	List<AdminLogin> adminLogins = adminLoginService.getAdminLogins();
	
	model.addAttribute("adminLogins", adminLogins);
	
	return "list-adminLogins";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	isUpdate = false;
	
	AdminLogin theAdminLogin = new AdminLogin();
	
	theModel.addAttribute("adminLogin", theAdminLogin);
	
	
	return "adminLogin-form";
}

@PostMapping("/saveAdminLogin")
public String saveAdminLogin(@ModelAttribute("adminLogin") AdminLogin theAdminLogin){
	
	
	boolean errors = false;


	 List<AdminLogin> adminLogins = adminLoginService.getAdminLogins();

		
	 	// Check for Username
	 	boolean isValidRegistration = true;
		
		for (AdminLogin adminLoginTemp : adminLogins){
			
			if ( !( isUpdate && theAdminLogin.getId() == adminLoginTemp.getId() ) ){
				if ( theAdminLogin.getUserName().equals(adminLoginTemp.getUserName()) ){
					isValidRegistration = false;break;
				}
			}
			
		}
		if ( theAdminLogin.getUserName().equals("Please Enter a Unique Username") || theAdminLogin.getUserName().equals("Please Enter a Valid Username") ){
			theAdminLogin.setUserName("Please Enter a Valid Username");
			
			errors = true;
		}
		if (!isValidRegistration){
			theAdminLogin.setUserName("Please Enter a Unique Username");
		
			errors = true;
		}
		
		
		// Empty Field Checks
		//Username
		if ( theAdminLogin.getUserName().equals("") || theAdminLogin.getUserName().equals("Please Enter a Valid Username") ){
			theAdminLogin.setUserName("Please Enter a Valid Username");
			errors = true;
		}
		//Password
		if ( theAdminLogin.getPassword().equals("") || theAdminLogin.getPassword().equals("Please Enter a Valid Password") ){
			theAdminLogin.setPassword("Please Enter a Valid Password");
			errors = true;
		}
		
		
		if (errors){
			
			return "adminLogin-form";
		}
	
	adminLoginService.saveAdminLogin(theAdminLogin);
	
	
	
	return "redirect:/admin/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("adminLoginId") int theId, Model theModel){
	
	isUpdate = true;
	
	AdminLogin theAdminLogin = adminLoginService.getAdminLogin(theId);
	
	theModel.addAttribute("adminLogin", theAdminLogin);
	
	return "adminLogin-form";
	
	
}

@GetMapping("/delete")
public String deleteAdminLogin(@RequestParam("adminLoginId") int theId){
	 adminLoginService.deleteAdminLogin(theId);
	
	 return "redirect:/admin/list";
	



}

}
