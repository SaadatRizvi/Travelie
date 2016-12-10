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

import com.travelie.entity.VanType;
import com.travelie.service.VanTypeService;

@Controller
@RequestMapping(value = "/vanType")
public class VanTypeController {
	
	
	@Autowired
	VanTypeService vanTypeService;
	
@GetMapping("/list")
public String listVanTypes(Model model){
	
	List<VanType> vanTypes = vanTypeService.getVanTypes();
	
	model.addAttribute("vanTypes", vanTypes);
	
	return "list-vanTypes";
	
}

@GetMapping("/showFormForAdd")
public String showFormForAdd(Model theModel){
	
	VanType theVanType = new VanType();
	
	theModel.addAttribute("vanType", theVanType);
	
	
	return "vanType-form";
}

@PostMapping("/saveVanType")
public String saveVanType(@ModelAttribute("vanType") VanType theVanType){
	
	vanTypeService.saveVanType(theVanType);
	
	
	
	return "redirect:/vanType/list";
}

@GetMapping("/showFormForUpdate")
public String showFormForUpdate (@RequestParam("vanTypeId") int theId, Model theModel){
	
	VanType theVanType = vanTypeService.getVanType(theId);
	
	theModel.addAttribute("vanType", theVanType);
	
	return "vanType-form";
	
	
}

@GetMapping("/delete")
public String deleteVanType(@RequestParam("vanTypeId") int theId){
	 vanTypeService.deleteVanType(theId);
	
	 return "redirect:/vanType/list";
	



}

}
