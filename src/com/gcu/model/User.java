package com.gcu.model;

public class User {
	private String firstName;
	private String lastName;
	private int gender;
	
	public User() {
		firstName = "";
		lastName = "";
		gender = -1;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	
	
	
}
