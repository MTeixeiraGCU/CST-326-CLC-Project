package com.gcu.model;

import java.math.BigDecimal;

public class Product {
	
	String name;
	
	BigDecimal cost;
	
	String description;
	
	public Product()
	{
		name = "";
		cost = new BigDecimal("0.00");
		description = "";
	}
	
	//getters and setters
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
