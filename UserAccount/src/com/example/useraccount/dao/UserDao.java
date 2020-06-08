package com.example.useraccount.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.useraccount.model.User;

public class UserDao {
	
	//method for registering new users
	public int registerUser(User user) throws ClassNotFoundException {
		
		String insert_user_sql = "INSERT INTO user" + 
				"(firstname, lastname, username, password, email) VALUES " +
				"(?, ?, ?, ?, ?)";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			
			Connection connection = UserAccountConnection.getConnection();
		
			PreparedStatement preparedStatement = connection.prepareStatement(insert_user_sql);
			
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getLastname());
			preparedStatement.setString(3, user.getUsername());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getEmail());
			
			System.out.println(preparedStatement);
			
			result = preparedStatement.executeUpdate();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	//method for logging in and checking that the username and password are correct
	public boolean findUser(User user) throws ClassNotFoundException {
		
		boolean userexists = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Binary makes sure username and password are case sensitive
		String find_user_sql = "SELECT * FROM user WHERE BINARY username = ? AND BINARY password = ?";
		
		try {
			
			Connection connection = UserAccountConnection.getConnection();
		
			PreparedStatement preparedStatement = connection.prepareStatement(find_user_sql);
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			userexists = rs.next();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userexists;
		
	}
	
	//method for checking if the user already exists when registering
	public boolean checkUser(User user) throws ClassNotFoundException {
		
		boolean userexists = false;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String find_user_sql = "SELECT * FROM user WHERE username = ? OR email = ?";
		
		try {
			
			Connection connection = UserAccountConnection.getConnection();
		
			PreparedStatement preparedStatement = connection.prepareStatement(find_user_sql);
			
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getEmail());
			
			System.out.println(preparedStatement);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			userexists = rs.next();
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userexists;
		
	}

}
