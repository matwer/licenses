package com.shad.licenses.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.licenses.models.Person;
import com.shad.licenses.services.LicenseService;
import com.shad.licenses.services.PersonService;


@Controller
public class PersonController {
	private final PersonService personSvc;
	private final LicenseService licenseSvc;
	
	public PersonController(PersonService personSvc, LicenseService licenseSvc) {
		this.personSvc = personSvc;
		this.licenseSvc = licenseSvc;
	}
	
	/**
	 * set up a route to redirect / to the New Person page
	 **/
	@RequestMapping("/")
	public String main() {
		return "redirect:/persons/add";
	}
	
	/**
	 * set up a route for displaying the New Person page
	 **/
	@RequestMapping("/persons/add")
	public String displayNewPersonForm(@ModelAttribute("person") Person p) {
		return "/persons/new.jsp";
	}
	
	/**
	 * set up a route for adding a person to the db
	 **/
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String newPerson(@Valid @ModelAttribute ("person") Person p, BindingResult result) {
		if(result.hasErrors()) {
			return "/persons/new.jsp";
        } else {
        	personSvc.addEntry(p);
			return "redirect:/persons/add";
        }
	}
	
	/**
	 * set up a route for displaying a persons license
	 **/
	@RequestMapping(value="/persons/{id}")
	public String readOne(@PathVariable("id") Long id, Model model) {
		Person p = personSvc.findEntry(id);
		model.addAttribute("person", p);
		return "/persons/showLicense.jsp";
	}

}

