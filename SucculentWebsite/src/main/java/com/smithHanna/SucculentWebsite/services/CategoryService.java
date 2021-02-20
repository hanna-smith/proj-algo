package com.smithHanna.SucculentWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.repositories.CategoryRepository;

import java.util.List; 

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cRepo; 
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public void addProduct(Category category, Product product) {
		List<Product> currentProducts = category.getProducts();
		currentProducts.add(product);
		this.cRepo.save(category);
	}
	
	public void removeProduct(Category category, Product product) {
		List<Product> currentProducts = category.getProducts();
		currentProducts.remove(product);
		this.cRepo.save(category);
	}
}
