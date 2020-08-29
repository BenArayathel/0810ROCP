package com.kash.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

	public static void getHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		if(request.getSession(false) == null) {
			response.setStatus(403);
			response.sendRedirect("http://localhost:8080/FinalProjectV1/api/");
		} else {
			
			System.out.println("Inside getHomePage method " + request.getSession().getAttribute("user"));
			request.getRequestDispatcher("/Home.html").forward(request, response);
		}
		
	}

	public static void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false) != null) {
			response.sendRedirect("http://localhost:8080/FinalProjectV1/api/home");
		}
		else {
			request.getRequestDispatcher("/Login.html").forward(request, response);
		}
		
	}

	public static void getFailedLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession(false) != null) {
			response.sendRedirect("http://localhost:8080/FinalProjectV1/api/home");
		}
		else {
			request.getRequestDispatcher("/FailedLogin.html").forward(request, response);
		}
	}
}
