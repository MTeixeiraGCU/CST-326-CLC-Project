package com.gcu.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Sale {
	private int id;
	
	private String name;
	
	@NotNull(message="Please enter a sale percentage amount!")
	@Size(min=0, max=100, message="Value must be between 0 and 100")
	private double amount;
	
	private List<Tag> tags;
	
	private Date startDate;
	
	private Date endDate;
	
	public Sale() {
		id = -1;
		name = "";
		amount = 0;
		tags = new ArrayList<Tag>();
		startDate = new Date();
		endDate = new Date();
	}

	//getters and setters
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public List<Tag> getTags() {
		return tags;
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
