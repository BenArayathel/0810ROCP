<<<<<<< HEAD
package main.java.com.revature.servlets;

import java.io.IOException;
=======
package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
>>>>>>> 6bb79a10fcb3e78822c11a0c9ba3e0884ef93279
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
/**
 * Servlet implementation class CookieServlet
 */
public class CookieServlet extends HttpServlet {
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//to grab cookies - requesting the info from us
		Cookie[] listOfCookies = request.getCookies();
		System.out.println(listOfCookies[0].getName());
		System.out.println(listOfCookies[0].getValue());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c = new Cookie("planet","Jupieter");
		
		// seconds
		c.setMaxAge(20); //how much time the cookie will exist for
		
		response.addCookie(c);
		
=======

public class CookieServlet extends HttpServlet {

  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] listOfCookies = request.getCookies();
		
		System.out.println(listOfCookies[0].getName());
		System.out.println(listOfCookies[0].getValue());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie c = new Cookie("planet", "be");
		
		c.setMaxAge(20); //How long it will live on client machine
		
		response.addCookie(c);
		
		RequestDispatcher redis = request.getRequestDispatcher("/SuperSecureServlet");
		
		redis.forward(request, response);
		
//		response.sendRedirect("http://localhost:9999/MovingAboutMaven/SuperSecureServlet");
		
>>>>>>> 6bb79a10fcb3e78822c11a0c9ba3e0884ef93279
		
	}

}
