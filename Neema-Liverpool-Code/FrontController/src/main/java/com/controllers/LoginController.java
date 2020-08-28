package com.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/*
 * business logic
 */
public class LoginController {

	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		if(!request.getMethod().equals("POST")) {
			System.out.println("You've reached the login method, inside the LoginController");
		response.sendRedirect("http://localhost:8080/FrontController/api/"); //sent back to home page
		
		} else { //do login will navigate to home
			
	
		String username = request.getParameter("user");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user",  username);
		
		response.setStatus(300);
		
		response.sendRedirect("http://localhost:8080/FrontController/api/home");
	}
	}
	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
	//when you log out itll take you back to the home page	
		response.sendRedirect("http://localhost:8080/FrontController/api/");
		
	}

}
