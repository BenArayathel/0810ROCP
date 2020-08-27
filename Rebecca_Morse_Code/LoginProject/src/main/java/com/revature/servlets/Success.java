package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/Success")
public class Success extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
//		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username").equals("Becca")) {
		//false makes sure no new session created if there isn't one. this is for when they should be logged in. 
		request.getRequestDispatcher("/success.html").forward(request, response);
		} else {
			response.sendRedirect("http://localhost:1234/LoginProject/login");
			//this will make it a get for sure, regardless of what kind of response was passed in.
			//redirects need the full URI
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
