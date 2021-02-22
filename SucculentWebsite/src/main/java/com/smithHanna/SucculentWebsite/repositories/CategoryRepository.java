package com.smithHanna.SucculentWebsite.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product; 
import java.util.List; 
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findByProductsNotContaining(Product product);
	List<Category> findAll();
	
}
