package com.gcu.business;

import com.gcu.model.User;

public interface UserBusinessInterface {
	
	public static final int LOCKOUT_COUNT = 10;
	
	public boolean ValidateCredintials(User user);
	public boolean RegisterUser(User user);
	public boolean CheckUniqueEmail(String email);
}
