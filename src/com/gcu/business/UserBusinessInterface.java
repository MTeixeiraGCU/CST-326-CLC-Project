package com.gcu.business;

import com.gcu.model.User;

public interface UserBusinessInterface {
	
	public static final int LOCKOUT_COUNT = 10;
	
	public boolean ValidateCredintials(String email, String Password);
	public boolean RegisterUser(User user);
	public boolean IsAdmin(int id);
	public int GetIdFromEmail(String email);
}
