package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Fail
 */
//@WebServlet("/Fail")
public class Fail extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher redir = request.getRequestDispatcher("/fail.html");
		redir.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("username").equals("Becca")) {
			HttpSession session = request.getSession();			
			session.setAttribute("username", request.getParameter("username"));
			response.sendRedirect("http://localhost:1234/LoginProject/success");
		} else {
			response.sendRedirect("http://localhost:1234/LoginProject/fail");
		}
	}

}
