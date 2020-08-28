package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController {

	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

		System.out.println("You've reached the login method, inside the LoginController");
		
		if(!request.getMethod().equals("POST")) {
			
			System.out.println("That's a" + request.getMethod() + " method, invalid method");
			response.sendRedirect("http://localhost:9999/HelloFrontController/api/");
			
		}else {
			
			String username = request.getParameter("user");
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user", username);
			
			response.setStatus(300);
			
			response.sendRedirect("http://localhost:9999/HelloFrontController/api/home");
			
		}
		
		
	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		
		response.sendRedirect("http://localhost:9999/HelloFrontController/api/");
		
	}

}
