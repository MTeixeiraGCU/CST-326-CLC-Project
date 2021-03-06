package com.gcu.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	int id;
	
	@NotNull(message="You must provide an email for you login!")
	@Pattern(regexp="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\"
				  + "x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*["
				  + "a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\"
				  + ".){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-"
				  + "\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", message="Must be a valid email!")
	String email;
	
	@NotNull(message="Please enter a password!")
	@Size(min=6, max=18, message="Password must be 6 or more characters and less than 18!")
	@Pattern(regexp="(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&]).{6,18}$", 
	         message="Password must contain at least one number, one letter, and a symbol!")
	
	String password;
	
	String confirmPassword;
	
	@NotNull(message="You must enter a value for the first name!")
	@Size(min=2, max=25, message="First name must be be at least 2 letters but less than 26!")
	String firstName;
	
	@NotNull(message="You must enter a value for the last name!")
	@Size(min=2, max=25, message="Last name must be be at least 2 letters but less than 26!")
	String lastName;
	
	boolean isAdmin;
	
	@Valid
	Address address;
	
	public User() {
		id = -1;
		email = "";
		password = "";
		firstName = "";
		lastName = "";
		address = new Address();
		isAdmin = false;
	}

	//getters and setters
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
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
}
