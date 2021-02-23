package com.smithHanna.SucculentWebsite.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank; 


@Entity 
@Table(name="subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String numOfPlants; 
	private String subLengthInMonths; 
	private String shipmentDate;  
	private double subAmount; 
	@NotBlank
	private String reciever; 
	@NotBlank
	private String recAddress; 
	private String recAddress2; 
	@NotBlank
	private String recCity; 
	
	private String recState; 
	@NotBlank
	private String recZip; 
	private String optionalMessage; 
	@Column(updatable=false)
	private Date createdAt; 
	private Date updatedAt; 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user; 
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinTable(
			name=("subscription_details"),
			joinColumns = @JoinColumn(name=("subscription_id")),
			inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products; 
	public Subscription() {
		
	}

	public Subscription(String plants, String length, String shipment, String rec, String add1, String add2, String city, String state, String zip, String message) {
		this.numOfPlants = plants; 
		this.subLengthInMonths = length; 
		this.shipmentDate = shipment; 
		this.reciever = rec; 
		this.recAddress = add1; 
		this.recAddress2 = add2; 
		this.recCity = city; 
		this.recState = state; 
		this.recZip = zip; 
		this.optionalMessage = message; 
		
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumOfPlants() {
		return numOfPlants;
	}

	public void setNumOfPlants(String numOfPlants) {
		this.numOfPlants = numOfPlants;
	}

	public String getSubLengthInMonths() {
		return subLengthInMonths;
	}

	public void setSubLengthInMonths(String subLengthInMonths) {
		this.subLengthInMonths = subLengthInMonths;
	}

	public String getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(String shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public double getSubAmount() {
		return subAmount;
	}

	public void setSubAmount(double subAmount) {
		this.subAmount = subAmount;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getRecAddress() {
		return recAddress;
	}

	public void setRecAddress(String recAddress) {
		this.recAddress = recAddress;
	}

	public String getRecAddress2() {
		return recAddress2;
	}

	public void setRecAddress2(String recAddress2) {
		this.recAddress2 = recAddress2;
	}

	public String getRecCity() {
		return recCity;
	}

	public void setRecCity(String recCity) {
		this.recCity = recCity;
	}

	public String getRecState() {
		return recState;
	}

	public void setRecState(String recState) {
		this.recState = recState;
	}

	public String getRecZip() {
		return recZip;
	}

	public void setRecZip(String recZip) {
		this.recZip = recZip;
	}

	public String getOptionalMessage() {
		return optionalMessage;
	}

	public void setOptionalMessage(String optionalMessage) {
		this.optionalMessage = optionalMessage;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
