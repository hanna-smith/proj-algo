package com.smithHanna.SucculentWebsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.EmailUpdater;

@Repository 
public interface EmailRepository extends CrudRepository<EmailUpdater, Long> {

	boolean existsByEmail(String email);
	
}
