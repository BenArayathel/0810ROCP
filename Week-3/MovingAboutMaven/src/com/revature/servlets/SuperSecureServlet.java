package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SuperSecureServlet
 */
public class SuperSecureServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false) == null) {
			
			System.out.println("Get a session");
			
		} else if (request.getSession(false).getAttribute("user").equals("ben")) {
			System.out.println("Welcome ben");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getSession(false) == null) {
			
			System.out.println("Get a session");
			
		} else if (request.getSession(false).getAttribute("user").equals("ben")) {
			System.out.println("Welcome ben");
		}
		
//		System.out.println(request.getSession().getAttribute("planet"));
		

		
	}

}
