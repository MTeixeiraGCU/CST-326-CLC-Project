package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.DataAccessObjectInterface;
import com.gcu.model.User;

public class UserBusinessService implements UserBusinessInterface{

	@Autowired
	DataAccessObjectInterface<User> udao;
	
	@Override
	public boolean ValidateCredintials(String email, String password) {
		int id = GetIdFromEmail(email);
		if(id == -1)
			return false;
		if(udao.get(id).getPassword().equals(password))
			return true;
		return false;
	}
	
	@Override
	public boolean IsAdmin(int id) {
		return udao.get(id).isAdmin();
	}
	
	@Override
	public boolean RegisterUser(User user) {
		return udao.add(user);
	}
	
	@Override
	public int GetIdFromEmail(String email) {
		for(User u : udao.getAll()) {
			if(u.getEmail().equals(email)) {
				return u.getId();
			}
		}
		return -1;
	}
}
