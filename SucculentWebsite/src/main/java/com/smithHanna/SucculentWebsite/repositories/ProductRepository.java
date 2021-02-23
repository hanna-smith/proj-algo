package com.smithHanna.SucculentWebsite.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product; 

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findByProductDescriptionContaining(String search);
	List<Product> findByCategoryId(Long id);
	List<Product> findAll();
	List<Product> findByCategoryNotContaining(Category category);
}
