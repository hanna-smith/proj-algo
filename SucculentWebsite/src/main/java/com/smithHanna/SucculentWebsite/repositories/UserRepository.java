package com.smithHanna.SucculentWebsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.User;

@Repository 
public interface UserRepository extends CrudRepository<User, Long> {

	User findByEmail(String email);
	boolean existsByEmail(String email);
}
