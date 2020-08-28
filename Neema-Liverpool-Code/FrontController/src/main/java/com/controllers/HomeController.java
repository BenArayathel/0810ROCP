package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {

	public static String logoutButton() {
		String s = "<form action =\"FrontControllerTemplate/api/logout\">\r\n" + " <button type = \submit\">logout</button>\r\n" + "</form>";
				return s;
	}
	
	public HomeController(HttpServletRequest request, HttpServletResponse response) throws IOException{
		//making sure a session is a session
	
		if(request.getSession(false) == null) {
			response.setStatus(403); 
			response.sendRedirect("http://localhost:8080/FrontController/api/"); //default 
		}else {
			System.out.println("inside getHomePage method " + request.getSession(false).getAttribute("user"));
		response.getWriter().write("<h1> Welcome to our banking app" + request.getSession(false).getAttribute("user"));
		response.getWriter().write(logoutButton()); ///
		}
	}

	public static void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/LoginPage.html").forward(request,response);
		
	}
//failed login method
}
