package com.gcu.model;

public class Tag {

	int id;
	String name;
	
	public Tag()
	{
		id = -1;
		name = "";
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
	
	
}
