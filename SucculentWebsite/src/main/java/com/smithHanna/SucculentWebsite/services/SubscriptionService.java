package com.smithHanna.SucculentWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.Subscription;
import com.smithHanna.SucculentWebsite.repositories.SubscriptionRepository; 

@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository sRepo; 
	
	public Subscription createSubscription(Subscription subscription) {
		return this.sRepo.save(subscription);
	}
	
	public Subscription updateSubscription(Subscription updatedSubscription) {
		return this.sRepo.save(updatedSubscription);
	}
	
	public void deleteSubscription(Long id){
		this.sRepo.deleteById(id);
	}
	
}
