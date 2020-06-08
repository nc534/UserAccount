package com.example.useraccount.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//do not create a new session if session is null
		HttpSession session = request.getSession(false);
		String user = (String) session.getAttribute("user");
		
		//to prevent from accessing page after logging out
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0);
		
        //if the user's session is not null, go to the user account page, else, go to login page
		if (user != null) {
			
			request.getRequestDispatcher("/WEB-INF/views/userinfo.jsp").forward(request, response);
		
		}else {
			
			response.sendRedirect("login");
		}
		
	}

}
