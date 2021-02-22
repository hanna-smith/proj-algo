package com.smithHanna.SucculentWebsite.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.smithHanna.SucculentWebsite.models.Category;
import com.smithHanna.SucculentWebsite.models.Product;
import com.smithHanna.SucculentWebsite.services.CatProdService;
import com.smithHanna.SucculentWebsite.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
 
	@Autowired
	private CatProdService cService; 
	@Autowired
	private UserService uService; 
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/prodImages/";
	
	@GetMapping("/productManagement")
	public String prodManagement(Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		return "admin/productmanagment.jsp"; 
	}
	
	@GetMapping("/addAdmin")
	public String addAdmin(Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		return "admin/addAdmin.jsp";
	}
	
	@GetMapping("/addCategory")
	public String addCategory(@ModelAttribute("category")Category category, Principal principal, Model model) {
		String email = principal.getName();
        model.addAttribute("user", uService.findUserByEmail(email));
		
		return "admin/newCategory.jsp"; 
	}
	
	@PostMapping("/addCategory")
	public String createCategory(@Valid @ModelAttribute("category")Category category, BindingResult result, Model model) {
		if(result.hasErrors()) {
			
			return "admin/newCategory.jsp"; 
		}
		this.cService.createCategory(category);
		return "redirect:/admin/addCategory"; 
	}
	
	@GetMapping("/addProduct")
	public String addProduct(@ModelAttribute("product")Product product, Model model) {
		List<Product> allProducts = this.cService.allProducts();
		model.addAttribute("allProducts", allProducts);
		List<Category> allCategories = this.cService.allCategories();
		model.addAttribute("allCategories", allCategories);
		return "admin/newProduct.jsp"; 
	}
	
	@PostMapping("/addProduct")
	public String addProd(@RequestParam("pic") MultipartFile file, @RequestParam("productDescription")String desc, @RequestParam("price")double price, @RequestParam("name")String name, @ModelAttribute("product")Product product, RedirectAttributes redAttrs, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "redirect:/admin/addProduct"; 
		}
		if(file.isEmpty()) {
			redAttrs.addFlashAttribute("message", "Upload field cannot be empty");
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/prodImages/" + file.getOriginalFilename();
			this.cService.uploadProductPic(url, name, desc, price);
	
		}catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/addProduct"; 
		 
	}
	
	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id")Long id, Model model) {
		List<Product> allProducts = this.cService.allProducts();
		model.addAttribute("allProducts", allProducts);
		List<Category> allCategories = this.cService.allCategories();
		model.addAttribute("allCategories", allCategories);
		Product product = this.cService.findProductById(id);
		model.addAttribute("product", product);
		return "admin/editProduct.jsp";
	}
	
	@PostMapping("/editProduct/{id}")
	public String updateProduct(@PathVariable("id")Long id, @Valid @ModelAttribute("product")Product product, @RequestParam("pic") MultipartFile file, @RequestParam("productDescription")String desc, @RequestParam("price")double price, @RequestParam("name")String name, RedirectAttributes redAttrs, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Product> allProducts = this.cService.allProducts();
			model.addAttribute("allProducts", allProducts);
			List<Category> allCategories = this.cService.allCategories();
			model.addAttribute("allCategories", allCategories);
			Product prodEdit = this.cService.findProductById(id);
			model.addAttribute("product", prodEdit);
			return "admin/editProduct.jsp";
		}
		this.addProd(file, desc, price, name, product, redAttrs, result, model);
		this.cService.updateProduct(product);
		return "redirect:/admin/addProduct"; 
		
	}
	
	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id")Long id) {
		this.cService.deleteProduct(id);
		return "redirect:/admin/addProduct"; 
	}
	
}
