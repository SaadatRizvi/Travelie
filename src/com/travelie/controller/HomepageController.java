package com.travelie.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.travelie.entity.Customer;

@Controller
@RequestMapping(value = "/")
public class HomepageController {

	
	@RequestMapping("homepage")
	public String showHomepage(Model model){
		
		
		return "index";
	}
	
	
	
}
