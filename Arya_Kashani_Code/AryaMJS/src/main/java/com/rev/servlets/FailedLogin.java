package com.rev.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FailedLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException 
	{
		
		//req.getSession().invalidate();
		
		RequestDispatcher redir = req.getRequestDispatcher("/Fail.html");
		redir.forward(req, resp);
		
	}
	

}
