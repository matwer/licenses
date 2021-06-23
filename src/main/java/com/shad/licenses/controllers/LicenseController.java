package com.shad.licenses.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shad.licenses.models.License;
import com.shad.licenses.models.Person;
import com.shad.licenses.services.LicenseService;
import com.shad.licenses.services.PersonService;

@Controller
public class LicenseController {
	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	@RequestMapping("/licenses/add")
	public String displayNewLicenseForm(@ModelAttribute("license") License l,  Model model) {
	   /**
		* build a list of Persons without a license
		**/
		List<Person> pList = personService.findPeopleWithNoLicense();
		System.out.println(pList);
		// key ion quotes
		model.addAttribute("pList", pList);
		return "/licenses/new.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String newLicense(@Valid @ModelAttribute ("license") License l, BindingResult result) {
		
		if(result.hasErrors()) {
			return "/licenses/new.jsp";
        } else {
        	licenseService.addEntry(l);
			return "redirect:/licenses/add";
        }
	}

}
