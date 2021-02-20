package com.smithHanna.SucculentWebsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.Subscription;

import java.util.List; 
@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

	List<Subscription> findByUserId(Long id);
}
