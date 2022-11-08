package com.besant.app.repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.besant.app.pojo.User;


public class JdbcConnection {
	
	public User getUserValueFromUserId(String userId) {
		User user= null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println(userId);
		
		Connection con= DriverManager.getConnection("jdbc:mySql://localhost:3306/banking","root","Pass@123");
		PreparedStatement ps= con.prepareStatement("select * from login_details where user_id=?");
		ps.setString(1, userId);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			user= new User();
			user.setUserId(rs.getString(1));
			user.setPassword(rs.getString(2));			
		}	
		
		}catch(Exception e) {
			
			
		}
		return user;
		
	}

	
}
