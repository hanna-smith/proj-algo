package com.smithHanna.SucculentWebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.models.Subscription;
import com.smithHanna.SucculentWebsite.repositories.SubscriptionRepository; 
@Service
public class SubscriptionService {

	@Autowired
	private SubscriptionRepository sRepo; 
	
	public Subscription createSubscription(Subscription subscription) {
		return this.sRepo.save(subscription);
	}
	
	public Subscription findSubById(Long id){
		return this.sRepo.findById(id).orElse(null);
	}
	public List<Subscription> findAllSubsByUserId(Long id){
		return this.sRepo.findByUserId(id);
	}
	public Subscription updateSubscription(Subscription updatedSubscription) {
		return this.sRepo.save(updatedSubscription);
	}
	
	public void deleteSubscription(Long id){
		this.sRepo.deleteById(id);
	}
	
	public void addProduct(Subscription subscription, Product product) {
		List<Product> subProducts = subscription.getProducts();
		subProducts.add(product);
		this.sRepo.save(subscription);
	}
	public void removeProduct(Subscription subscription, Product product) {
		List<Product> subProducts = subscription.getProducts();
		subProducts.remove(product);
		this.sRepo.save(subscription);
	}
	List<Subscription> findByCreatedAt(Subscription subscription){
		return this.sRepo.findOrderByCreatedAt(subscription);
	}
}
