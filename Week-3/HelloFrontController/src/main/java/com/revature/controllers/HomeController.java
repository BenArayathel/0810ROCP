package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	
	public static String logoutButton() {
		String s = "<form action = \"/HelloFrontController/api/logout\">\r\n" + 
				"	<button type = \"submit\">logout</button>\r\n" + 
				"</form>";
		
		return s;
	}

	public static void getHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException {

		if(request.getSession(false) == null) {
			response.setStatus(403);
			response.sendRedirect("http://localhost:9999/HelloFrontController/api/");
		} else {
			
			System.out.println("Inside getHomePage method " + request.getSession().getAttribute("user"));
			response.getWriter().write("<h1>Welcome to our banking app " + request.getSession(false).getAttribute("user") + "</h1>");
			
			response.getWriter().write(logoutButton());
		}
		
	}

	public static void getLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/LoginPage.html").forward(request, response);
		
	}

	public static void getFailedLoginPage(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
