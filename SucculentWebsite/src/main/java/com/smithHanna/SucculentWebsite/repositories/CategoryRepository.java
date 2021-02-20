package com.smithHanna.SucculentWebsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.Category; 

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	
}
