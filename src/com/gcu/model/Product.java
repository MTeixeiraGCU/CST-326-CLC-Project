package com.gcu.model;

import java.util.ArrayList;
import java.util.List;

public class Product {
	
	String image;
	
	String name;

	int costDollars;
	
	int costCents;
	
	String description;
	
	List<Tag> tags;
	
	public Product()
	{
		image = "";
		name = "";
		costDollars = 0;
		costCents = 0;
		description = "";
		tags = new ArrayList<Tag>();
	}
	
	public String getCost() {
		double cost = costDollars + (costCents * 0.01);
		return String.format("%,.2f", cost);
	}
	
	public void setCost(String cost)
	{
		double amount = Double.parseDouble(cost);
		this.costDollars = (int)amount / 1;
		this.costCents = (int)((amount % 1.0) * 100);
		System.out.println("$" + costDollars + "." + costCents);
	}
	
	//getters and setters
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
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
	
	public int getCostDollars() {
		return costDollars;
	}

	public void setCostDollars(int costDollars) {
		this.costDollars = costDollars;
	}

	public int getCostCents() {
		return costCents;
	}

	public void setCostCents(int costCents) {
		this.costCents = costCents;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
