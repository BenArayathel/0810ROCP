package main.java.com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.java.com.revature.models.Planet;

/**
 * Servlet implementation class SessionServlet
 */
public class SessionServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		HttpSession session = request.getSession(false); //return null if session doesnt exist. It wont create a new session 
		System.out.println(session.getAttribute("user"));
		System.out.println(session.getAttribute("planet"));
	} catch (NullPointerException n) {
		System.out.println("There is no session");
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//return current session or create a new session
		HttpSession session = request.getSession(); 
		
		Planet p = new Planet("Jupiter");
		/*
		 * if query parameter = "username"
		 * session set attribute username
		 */
		
		session.setAttribute("user", "neema");
		session.setAttribute("planet", "p");
	}

}
