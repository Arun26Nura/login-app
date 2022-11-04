package com.besant.app.service;

import com.besant.app.pojo.User;
import com.besant.app.repo.JdbcConnection;

public class LoginService {

	public boolean isValidUser(String userId, String password) {
		JdbcConnection con= new JdbcConnection();
		User user=con.getUserValueFromUserId(userId);
		if(user != null) {
			return user.getPassword().equals(password);
		}
		
		return false;
	}
}
