package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.revature.models.Planet;


public class SessionServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false); //return null if session does not exist
		
		System.out.println(session.getAttribute("user"));
		System.out.println(session.getAttribute("planet"));
		} catch (NullPointerException n) {
			System.out.println("There is no session!");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); //Either return the current session or create a new session.
		
		Planet p = new Planet("Jupiter");
		
		/*
		 * if query parameter = "username"
		 * 	session set attribute username 
		 * 
		 * ServiceLogic.doesUserExist(user);
		 * 
		 * User u = new User(user);
		 * if true
		 * 		session.setAttriubute("user", u)
		 */
		
		session.setAttribute("user", "ben");
		session.setAttribute("planet", p);
		
//		request.getRequestDispatcher("/SuperSecureServlet").forward(request, response);
		
		response.sendRedirect("http://localhost:9999/MovingAboutMaven/SuperSecureServlet");
		

	}

}
