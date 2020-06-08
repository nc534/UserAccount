package com.example.useraccount.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//separate connection file for better practice
public class UserAccountConnection {

	private static final String URL = "jdbc:mysql://localhost:3306/useraccount?useSSL=false";
	private static final String user = "root";
	private static final String password = "rootroot";
	
	public static Connection getConnection(){
      
		try {
			
          //DriverManager.registerDriver(new Driver());
             return DriverManager.getConnection(URL, user, password);
             
      } catch (SQLException ex) {
          throw new RuntimeException("Error connecting to the database", ex);
      }
		
    }
	
}