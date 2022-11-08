package com.besant.app.service;

import com.besant.app.pojo.User;
import com.besant.app.repo.JdbcConnection;

public class LoginService {

	public int isValidUser(String userId, String password) {
		JdbcConnection con= new JdbcConnection();
		User user=con.getUserValueFromUserId(userId);
		if(user != null) {
			
			if( user.getPassword().equals(password))
				//Success
				return 0;
			else
				//Invalid Password
				return 2;
		}else {
			// No User profile found
			return 1;
		}
		
	}
	
	
}
