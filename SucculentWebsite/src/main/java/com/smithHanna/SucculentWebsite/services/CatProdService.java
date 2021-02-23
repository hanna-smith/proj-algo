package com.smithHanna.SucculentWebsite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.repositories.CategoryRepository;
import com.smithHanna.SucculentWebsite.repositories.ProductRepository; 

@Service
public class CatProdService {

	@Autowired
	private CategoryRepository cRepo; 
	@Autowired
	private ProductRepository pRepo; 
	
	public Category createCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	public Product findProductById(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	public Category findCategoryById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	public List<Product> allProducts(){
		return this.pRepo.findAll(); 
	}
	
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	public List<Category> findCategoryNotInProducts(Product product){
		return this.cRepo.findByProductsNotContaining(product);
	}
	
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts(); 
		products.add(product);
		this.cRepo.save(category);
	}
	
	public List<Product> findProductsNotInCategory(Category category){
		return this.pRepo.findByCategoryNotContaining(category);
	}
	
	public List<Category> allCategories(){
		return this.cRepo.findAll();
	}
	
	public void deleteProduct(Long id) {
		this.pRepo.deleteById(id);
	}
	public void deleteCategory(Long id) {
		this.cRepo.deleteById(id);
	}
	
	public List<Product> findByDescription(String search){
		return this.pRepo.findByProductDescriptionContaining(search);
	}
	
	public List<Product> findByCategoryId(Long id){
		return this.pRepo.findByCategoryId(id);
	}
	
	public void uploadProductPic(String image_url, String name, String productDescription, double price) {
		Product newProduct = new Product(image_url, name, productDescription, price);
		this.pRepo.save(newProduct);
	}
	
	public void updateProduct(Product updatedProduct) {
		this.pRepo.save(updatedProduct);
	}
	
	
}
