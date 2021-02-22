package com.smithHanna.SucculentWebsite.controllers;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smithHanna.SucculentWebsite.models.State;
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
    public String login(@RequestParam(value="error", required=false) String error, @RequestParam(value="logout", required=false) String logout, Model model) {
    	if(error != null) {
            model.addAttribute("errorMessage", "Invalid Credentials, Please try again.");
        }
        if(logout != null) {
            model.addAttribute("logoutMessage", "Logout Successful!");
        }
        return "login.jsp";
    }	
    
    
    
    @RequestMapping(value = {"/dashboard"})
    public String home(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", uService.findUserByEmail(email));
        return "userDashboard.jsp";
    }
    
    @GetMapping("/subscribe")
    public String registerForm(@ModelAttribute("user") User user, Model model) {
        model.addAttribute("states", State.States);
    	return "register.jsp";
    }
    
    @PostMapping("/subscribe")
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        uValidator.validate(user, result);
        if (result.hasErrors()) {
        	model.addAttribute("states", State.States);
            return "register.jsp";
        }
        uService.saveWithUserRole(user);
        return "redirect:/login";
    }
    
    @RequestMapping("/admin")
    public String adminPage(Principal principal, Model model) {
        String email = principal.getName();
        model.addAttribute("currentUser", uService.findUserByEmail(email));
        return "admin/adminPage.jsp";
    }
    

}
