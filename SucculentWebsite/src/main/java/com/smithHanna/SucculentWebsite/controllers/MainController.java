package com.smithHanna.SucculentWebsite.controllers;



import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;
import com.smithHanna.SucculentWebsite.models.Plant;
import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.models.State;
import com.smithHanna.SucculentWebsite.models.Subscription;
import com.smithHanna.SucculentWebsite.models.SubscriptionType;
import com.smithHanna.SucculentWebsite.services.CatProdService;
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
	@Autowired 
	private CatProdService cService; 
	 
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
	public String showSubs(Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		return "Subscriptions/showSubscriptions.jsp"; 
	}
	
	@GetMapping("/deleteSub/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		this.sService.deleteSubscription(id);
		return "redirect:/mySubs"; 
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
	public String giftSub(@ModelAttribute("subscription")Subscription subscription, Principal principal, Model model) {
		model.addAttribute("numOfPlants", Plant.numOfPlants);
		model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
		model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
		model.addAttribute("states", State.States);
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		return "Subscriptions/giftsub.jsp"; 
	}
	
	@PostMapping("/giftASucc")
	public String createSub(@Valid @ModelAttribute("subscription")Subscription subscription, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("numOfPlants", Plant.numOfPlants);
			model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
			model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
			model.addAttribute("states", State.States);
			return "Subscriptions/giftsub.jsp";
		}
		this.sService.createSubscription(subscription);
		return "redirect:/mySubs";
	}
	
	@GetMapping("/newSubscription")
	public String newSub(@ModelAttribute("subscription")Subscription subscription, Model model) {
		model.addAttribute("numOfPlants", Plant.numOfPlants);
		model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
		model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
		model.addAttribute("states", State.States);
		return "Subscriptions/newSub.jsp";
	}
	
	@PostMapping("/newSubscription")
	public String createPersonalSub(@Valid @ModelAttribute("subscription")Subscription subscription, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("numOfPlants", Plant.numOfPlants);
			model.addAttribute("subLengthInMonths", SubscriptionType.subLengthInMonths);
			model.addAttribute("shipmentDate", SubscriptionType.shipmentDate);
			model.addAttribute("states", State.States);
			return "Subscriptions/newSub.jsp";
		}
		this.sService.createSubscription(subscription);
		return "redirect:/mySubs";
	}
	
	
	@GetMapping("/chooseyoursuccs/{1}/{id}")
	public String succChoice(@PathVariable("1")Long catId, @PathVariable("id")Long id, @ModelAttribute("subscription")Subscription subscription, Model model) {
		model.addAttribute("subscription", this.sService.findSubById(id));
		List<Product> allSuccs = this.cService.findByCategoryId(catId);
		model.addAttribute("products", allSuccs);
		return "Subscriptions/chooseProds.jsp"; 
	}
	
	@GetMapping("/ordersummary/{id}")
	public String orderSumm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("subscription", this.sService.findSubById(id));
		return "Subscriptions/orderSumm.jsp"; 
	}
	
	

	
	
	

	 
}
