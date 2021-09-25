package com.gcu.business;

import com.gcu.model.User;

public class UserBusinessService implements UserBusinessInterface{

	@Override
	public boolean ValidateCredintials(User user) {
		if(user.getEmail() == "yo@yo.yo" && user.getPassword() == "123QWE!@#") {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean RegisterUser(User user) {
		return true;
	}
	
	@Override
	public boolean CheckUniqueEmail(String email) {
		return true;
	}
}
