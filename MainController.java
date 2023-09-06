package com.caroline.dojosninjas.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.caroline.dojosninjas.models.Dojo;
import com.caroline.dojosninjas.models.Ninja;
import com.caroline.dojosninjas.services.DojoService;
import com.caroline.dojosninjas.services.NinjaService;

import jakarta.validation.Valid;


@Controller
public class MainController {

	@Autowired
	private DojoService dojoService;
		
	@Autowired
	private NinjaService ninjaService;
		
	@GetMapping("/")
	public String startingPoint() {
		return "redirect:/dojos";
	}
		
	@GetMapping("/dojos")
	public String createDojoForm(@ModelAttribute("dojo") Dojo dojo) {
		
		return "create_dojo.jsp";
		
	}
	
	@PostMapping ("/dojos/create")
	public String createNewDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if (result.hasErrors()) {
			return "create_dojo.jsp";
		}
		else {
			
			dojoService.createDojo(dojo);
			
			return "redirect:/ninjas";
		}
	}
	
		
	@GetMapping ("/ninjas")
	public String createNinjaForm (@ModelAttribute("ninja") Ninja ninja, Model model ) {
			
			model.addAttribute("dojos", dojoService.findAllDojo());
			return "create_ninja.jsp";
	}
	
	
	@PostMapping ("/ninjas")
	public String createNewNinja(@Valid @ModelAttribute ("ninja") Ninja ninja, BindingResult result,
			Model modelview, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("dojos", dojoService.findAllDojo());
			return "ninja_create.jsp";
		}
		else {
			
			ninjaService.createNinja(ninja);
			System.out.print(ninja.getDojo().getId()); 
			Long dojoId = ninja.getDojo().getId();
			modelview.addAttribute("dojo", dojoId); 
			
			return String.format("redirect:/Dojos/%s", dojoId);
		}
	}
	
	@GetMapping ("/Dojos/{id}")
	public String showDojo (@PathVariable ("id") Long id, Model model) {
		
		Dojo dojo = dojoService.findDojoById(id);
		model.addAttribute("dojo", dojo);
		
		return "show_dojo.jsp";
	
	}
}


