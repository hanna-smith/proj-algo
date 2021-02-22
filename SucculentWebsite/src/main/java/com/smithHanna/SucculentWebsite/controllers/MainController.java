package com.smithHanna.SucculentWebsite.controllers;



import javax.validation.Valid;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;
import com.smithHanna.SucculentWebsite.models.Plant;
import com.smithHanna.SucculentWebsite.models.State;
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
	private SubscriptionService sService; 
	@Autowired
	private UserService uService;
	 
	@GetMapping("/")
	public String homePage(@ModelAttribute("email_updates")EmailUpdater emailupdater, Model model) {
		return "homePage.jsp"; 
	}
	
	@PostMapping("/")
	public String emailSubmit(@Valid @ModelAttribute("email_updates")EmailUpdater emailUpdater, BindingResult result) {
		if(result.hasErrors()) {
			return "homePage.jsp"; 
		}
		this.eService.createEmail(emailUpdater);
		return "redirect:/homepage"; 
	}
	
	@GetMapping("/mySubs")
	public String showSubs(@ModelAttribute("subscription")Subscription subscription, Model model) {
		return "Subscriptions/showSubscriptions.jsp"; 
	}
	
	@GetMapping("/howitworks")
	public String howItWorksPage() {
		return "StaticPages/howItWorks.jsp";
	}
	
	@GetMapping("/contactus")
	public String contactUs() {
		return "StaticPages/contactus.jsp";
	}
	@GetMapping("/whyus")
	public String whyUs() {
		return "StaticPages/whyUs.jsp"; 
	}
	
	@GetMapping("/giftASucc")
	public String newSub(@ModelAttribute("subscription")Subscription subscription, Principal principal, Model model) {
		model.addAttribute("numOfPlants", Plant.numOfPlants);
		model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
		model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
		model.addAttribute("states", State.States);
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		return "subscription.jsp"; 
	}
	
	@PostMapping("/giftASucc")
	public String createSub(@Valid @ModelAttribute("subscription")Subscription subscription, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("numOfPlants", Plant.numOfPlants);
			model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
			model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
			model.addAttribute("states", State.States);
			return "subscription.jsp";
		}
		this.sService.createSubscription(subscription);
		return "redirect:/chooseyoursuccs";
	}
	
	
	

	
	
	

	 
}
