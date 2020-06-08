package com.example.useraccount.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession(false);
		
			//if user's session is active, remove user and invalidate session
	        if(session.getAttribute("user") != null){
	        
	            session.removeAttribute("user");
	            session.setAttribute("user", null);
	            session.invalidate();
	            
	            //send user back to login page
	            response.sendRedirect("login");

	        }
	}

}
