package com.smithHanna.SucculentWebsite.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smithHanna.SucculentWebsite.models.User;
import com.smithHanna.SucculentWebsite.services.UserService;
import com.smithHanna.SucculentWebsite.validators.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService uService; 
	@Autowired 
	private UserValidator uValidator; 
	
	@GetMapping("/login")
	public String loginPage(@ModelAttribute("user")User user) {
		return "login.jsp"; 
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email")String email, @RequestParam("password")String password, RedirectAttributes redAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, password)) {
			redAttrs.addFlashAttribute("loginError", "Invalid Credentials, please enter a valid email/password combo.");
			return "redirect:/login"; 
		}
		User user = this.uService.findUserByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/userhomepage"; 
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/subscribe")
	public String subscribe(@ModelAttribute("user")User user) {
		return "register.jsp"; 
	}
	
	@PostMapping("/subscribe")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		uValidator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp"; 
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/subscriptiondetails"; 
	}

}
