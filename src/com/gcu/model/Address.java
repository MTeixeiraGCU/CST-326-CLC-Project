package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Address {
	
	@NotNull(message="You must provide a default address")
	private String addressOne;
	
	private String addressTwo;
	
	@Pattern(regexp="\\(\\d{3}\\)\\d{3}-\\d{4}",message="Phone number must be in the format (XXX)XXX-XXXX")
	private String phoneNumber;
	
	public Address()
	{
		addressOne = "";
		addressTwo = "";
		phoneNumber = "";
	}
	
	
	//getters and setters
	public String getAddressOne() {
		return addressOne;
	}
	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}
	public String getAddressTwo() {
		return addressTwo;
	}
	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
