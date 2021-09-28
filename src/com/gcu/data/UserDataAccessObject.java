package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.gcu.model.User;

public class UserDataAccessObject implements DataAccessObjectInterface<User> {

	private static List<User> users = null;
	private static int currentID = 1;
	
	@PostConstruct
	public void Initialize() {
		users = new ArrayList<User>();
		for(int i = 0;i < 4;i++)
		{
			User u = new User();
			u.setId(currentID);
			u.setEmail("yo@yo.yo" + currentID);
			u.setPassword("123QWE!@#" + currentID);
			u.setAdmin(currentID % 2 == 0?false:true);
			users.add(u);
			currentID++;
		}
	}
	
	@Override
	public User get(int id) {
		for(User u : users) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public boolean add(User t) {
		t.setId(currentID);
		currentID++;
		return users.add(t);
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User t) {
		// TODO Auto-generated method stub
		return false;
	}

}
