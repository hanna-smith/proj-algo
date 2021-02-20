package com.smithHanna.SucculentWebsite.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.repositories.ProductRepository;

import java.util.List; 

@Service
public class ProductService {

	@Autowired
	private ProductRepository pRepo; 
	
	//create
	public Product newProduct(Product product) {
		return this.pRepo.save(product);
	}
	//read
	public Product findProductById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	//delete
	public void deleteProduct(Long id) {
		this.pRepo.deleteById(id);
	}
	
	public List<Product> findByDescription(String search){
		return this.pRepo.findByProductDescriptionContaining(search);
	}
	
	public List<Product> findByCategory(Category search){
		return this.pRepo.findByCategories(search);
	}
	
	public void addCategory(Product product, Category category) {
		List<Category> currentCats = product.getCategories(); 
		currentCats.add(category);
		this.pRepo.save(product);
	}
	
	
}
