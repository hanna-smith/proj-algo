package com.smithHanna.SucculentWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;
import com.smithHanna.SucculentWebsite.repositories.EmailRepository;

@Service
public class EmailUpdaterService {

	@Autowired
	private EmailRepository eRepo; 
	
	public EmailUpdater createEmail(EmailUpdater emailUpdater) {
		return this.eRepo.save(emailUpdater);
	}
}
