package com.smithHanna.SucculentWebsite.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;
import com.smithHanna.SucculentWebsite.models.Plant;
import com.smithHanna.SucculentWebsite.models.Subscription;
import com.smithHanna.SucculentWebsite.models.SubscriptionType;
import com.smithHanna.SucculentWebsite.services.EmailUpdaterService;
import com.smithHanna.SucculentWebsite.services.SubscriptionService;
import com.smithHanna.SucculentWebsite.services.UserService;

@Controller
public class MainController {

	@Autowired 
	private EmailUpdaterService eService; 
	@Autowired
	private UserService uService; 
	@Autowired
	private SubscriptionService sService; 
	
	
	@GetMapping("/")
	public String homePage(@ModelAttribute("email_updates")EmailUpdater emailupdater) {
		return "homePage.jsp"; 
	}
	
	@PostMapping("/")
	public String emailSubmit(@Valid @ModelAttribute("email_updates")EmailUpdater emailUpdater, BindingResult result) {
		if(result.hasErrors()) {
			return "homePage.jsp"; 
		}
		this.eService.createEmail(emailUpdater);
		return "redirect:/"; 
	}
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id").equals(null)) {
			return "redirect:/"; 
		}
		Long userId = (Long)session.getAttribute("user_id");
		model.addAttribute("user", this.uService.findUserById(userId));
		return "userDashboard.jsp"; 
	}
	
	@GetMapping("/chooseyoursubscription")
	public String subTypePage(@ModelAttribute("subscription")Subscription subscription, Model model) {
		model.addAttribute("numOfPlants", Plant.numOfPlants);
		model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
		return "subscription.jsp"; 
	}
	
	@PostMapping("/chooseyoursubscription")
	public String subTypeSubmit(@Valid @ModelAttribute("subscription")Subscription subscription, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("numOfPlants", Plant.numOfPlants);
			model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
			return "subscription.jsp"; 
		}
		this.sService.createSubscription(subscription);
		return "redirect:/thismonth'ssucculents";
	}
}
