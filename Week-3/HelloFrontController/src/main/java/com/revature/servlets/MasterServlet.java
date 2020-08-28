package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controllers.RequestHelper;

//client -> masterServlet -> RequestHelper 

public class MasterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String greetings = getInitParameter("Greetings"); //Servlet Config
		
		String db = getServletContext().getInitParameter("databaseUrl"); //Servlet Context
		
		System.out.println(greetings);
		
		System.out.println(db);
		
//		String databasee = 
		
		RequestHelper.process(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestHelper.process(request,response);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestHelper.process(request,response);
	}

}
