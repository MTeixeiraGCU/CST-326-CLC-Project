package com.gcu.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {
	
	String name;

	BigDecimal cost;
	
	String description;
	
	List<Tag> tags;
	
	public Product()
	{
		name = "";
		cost = new BigDecimal("0.00");
		description = "";
		tags = new ArrayList<Tag>();
	}
	
	//getters and setters
	public List<Tag> getTags() {
		return tags;
	}
	
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BigDecimal getCost() {
		return cost;
	}
	
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
