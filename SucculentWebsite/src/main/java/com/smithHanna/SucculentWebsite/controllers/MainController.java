package com.smithHanna.SucculentWebsite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;

@Controller
public class MainController {


	
	@GetMapping("/")
	public String homePage(@ModelAttribute("email_updates")EmailUpdater emailupdater) {
		return "homePage.jsp"; 
	}
}
