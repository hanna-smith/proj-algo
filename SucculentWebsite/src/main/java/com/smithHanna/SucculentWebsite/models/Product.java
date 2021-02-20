package com.smithHanna.SucculentWebsite.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table; 


@Entity 
@Table(name="products")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String name; 
	private double price; 
	private byte image; 
	private String productDescription; 
	@Column(updatable=false)
	private Date createdAt; 
	private Date updatedAt; 
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name=("subscription_details"),
			joinColumns = @JoinColumn(name="product_id"),
			inverseJoinColumns = @JoinColumn(name="subscription_id"))
	private List<Subscription> subscriptions; 
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name=("products_categories"),
				joinColumns =@JoinColumn(name="product_id"),
				inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> categories; 
	
	public Product() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte getImage() {
		return image;
	}

	public void setImage(byte image) {
		this.image = image;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
}
