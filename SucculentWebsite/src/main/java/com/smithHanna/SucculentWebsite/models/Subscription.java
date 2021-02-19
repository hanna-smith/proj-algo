package com.smithHanna.SucculentWebsite.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank; 


@Entity 
@Table(name="subscriptions")
public class Subscription {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	@NotBlank
	private String numOfPlants; 
	@NotBlank
	private int subLengthInMonths; 
	@NotBlank
	@Future
	private Date shipmentDate; 
	@NotBlank
	private String plantSelection;
	@NotBlank
	private String customSelection; 
	private String optionalMessage; 
	@Column(updatable=false)
	private Date createdAt; 
	private Date updatedAt; 
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user; 
	
	public Subscription() {
		
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

	public int getSubLengthInMonths() {
		return subLengthInMonths;
	}

	public void setSubLengthInMonths(int subLengthInMonths) {
		this.subLengthInMonths = subLengthInMonths;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getPlantSelection() {
		return plantSelection;
	}

	public void setPlantSelection(String plantSelection) {
		this.plantSelection = plantSelection;
	}

	public String getCustomSelection() {
		return customSelection;
	}

	public void setCustomSelection(String customSelection) {
		this.customSelection = customSelection;
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
	
	public String getOptionalMessage() {
		return optionalMessage;
	}

	public void setOptionalMessage(String optionalMessage) {
		this.optionalMessage = optionalMessage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
