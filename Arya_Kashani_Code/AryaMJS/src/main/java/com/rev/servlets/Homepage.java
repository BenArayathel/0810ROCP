package com.rev.servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Homepage extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException 
	{
		
		HttpSession session = req.getSession(false);
		
		if (session == null) {
		
			String fname = req.getParameter("firstname");
			String lname = req.getParameter("lastname");
			
			boolean name_null = fname == null || lname == null;
			boolean name_empty = fname == ""  || lname == "";
			boolean name_space = fname == " " || lname == " ";
			
			if (name_null || name_empty || name_space) {
				RequestDispatcher redir = req.getRequestDispatcher("/Fail.html");
				redir.forward(req, resp);
			}
			else {
				
				session = req.getSession();
				session.setAttribute(fname, lname);
				
				RequestDispatcher redir = req.getRequestDispatcher("/Homepage.html");
				redir.forward(req, resp);
			}
		
		}
		
		else {
			RequestDispatcher redir = req.getRequestDispatcher("/Homepage.html");
			redir.forward(req, resp);
		}
		
	}
	

	
}
