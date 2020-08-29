package com.kash.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController {
	public static void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		System.out.println("You've reached the login method, inside the LoginController");
		
		if(!request.getMethod().equals("POST")) {
			
			System.out.println("That's a" + request.getMethod() + " method, invalid method");
			response.sendRedirect("http://localhost:8080/FinalProjectV1/api/");
			
		}
		else if(request.getParameter("user") == null || request.getParameter("user").equals("") || request.getParameter("user").equals(" ")) {
			HomeController.getFailedLoginPage(request, response);
		}
		else {
			
			String username = request.getParameter("user");
			
			// if user blank/null/empty => send to FailedLogin
			
			HttpSession session = request.getSession();
			
			session.setAttribute("user", username);
			
			response.setStatus(300);
			
			response.sendRedirect("http://localhost:8080/FinalProjectV1/api/home");
			
		}
		
		
	}

	public static void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		
		response.sendRedirect("http://localhost:8080/FinalProjectV1/api/");
		
	}
}
