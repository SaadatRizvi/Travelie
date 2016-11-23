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

import com.travelie.entity.Van;
import com.travelie.service.VanService;

@Controller
@RequestMapping(value = "/van")
public class VanController {
	
	
	@Autowired
	VanService vanService;
	
@GetMapping("/list")
public String listVans(Model model){
	
	List<Van> vans = vanService.getVans();
	
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
