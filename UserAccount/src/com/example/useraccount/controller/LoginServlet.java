package com.example.useraccount.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.useraccount.dao.UserDao;
import com.example.useraccount.model.User;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserDao userDao; 

	public void init() {
		userDao = new UserDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//get the username and password inputted in text box
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		//create user bean
		User user = new User();
		
		//set the username and password to this user
		user.setUsername(userName);
		user.setPassword(password);
		
		try {
			
			//check if username and password match the records
			if(userDao.findUser(user)) {
				
				//create a session for current user
				HttpSession session = request.getSession();
				session.setAttribute("user", userName);
				
				//send user to user account page
				response.sendRedirect("user");
		
			}else {
				
				//send user to login page
				out.print("Wrong username and password. If you don't have an account, please register.");
				request.getRequestDispatcher("/WEB-INF/views/login.jsp").include(request, response);  
			}
			
			out.close();
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
