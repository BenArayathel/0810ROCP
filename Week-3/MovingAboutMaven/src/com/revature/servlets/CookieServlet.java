package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		
	}

}
