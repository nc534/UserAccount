package com.example.useraccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.useraccount.dao.UserDao;
import com.example.useraccount.model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao = new UserDao();

    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/userregister.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//set user fields with parameters from registration text box
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		Boolean userExists = false;
		
		PrintWriter out = response.getWriter();
		
		User user = new User();
		
			user.setFirstname(firstName);
			user.setLastname(lastName);
			user.setUsername(userName);
			user.setPassword(password);
			user.setEmail(email);
		
		//check if user's username or email is already taken
		try {
			userExists = userDao.checkUser(user);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//only try to insert new user if the check that user doesn't already exist passes
		if (userExists == false) {
			try {
				userDao.registerUser(user);
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		//if the username or email is already taken, go back to login page without adding new user, else, new user is created and sent back to login
		if (userExists == true) {
			
			out.print("Username or Email already exists.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response); 
			
		}else {
		
			out.print("Account created.");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);  
			
		}
		
		out.close();
	}

}
