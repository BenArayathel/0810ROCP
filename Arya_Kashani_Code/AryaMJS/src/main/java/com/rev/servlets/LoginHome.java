package com.rev.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHome extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException 
	{
		try {
			
			HttpSession session = req.getSession(false);
			
			if ( session == null) {
				RequestDispatcher redir = req.getRequestDispatcher("/Login.html");
				redir.forward(req, resp);
			}
			else {
				RequestDispatcher redir = req.getRequestDispatcher("/Homepage.html");
				redir.forward(req, resp);
			}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException 
	{
		req.getSession().invalidate();
		doGet(req,resp);
	}

	
	
}
