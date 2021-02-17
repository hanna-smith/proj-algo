package com.smithHanna.SucculentWebsite.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.smithHanna.SucculentWebsite.models.User;
import com.smithHanna.SucculentWebsite.repositories.UserRepository;

@Component
public class UserValidator {

	@Autowired 
	private UserRepository uRepo; 
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors error) {
		User user = (User) target;
		if(!user.getPassword().equals(user.getConfirmPass())) {
			error.rejectValue("password", "match", "Passwords do not match.");
		}
		if(this.uRepo.existsByEmail(user.getEmail())) {
			error.rejectValue("email", "Unique", "You already have an account.");
		}
		
		if(user.getfName().isEmpty()) {
			error.rejectValue("fName", "noEmpties", "You must provide a valid name.");
		}
		if(user.getlName().isEmpty()) {
			error.rejectValue("lName", "noEmpties", "You must provide a valid last name.");
		}
	}
}
