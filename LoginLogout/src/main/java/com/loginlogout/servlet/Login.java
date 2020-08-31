package com.loginlogout.servlet;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String trueUsername = "login";
		String truePassword = "password";
		
		if (username.equals(trueUsername) && password.equals(truePassword)) {
			HttpSession session = request.getSession();
			session.setAttribute("Successful", true);
			request.getRequestDispatcher("/Success.html").forward(request, response);
			
		} else {
			response.setStatus(418);
			response.sendRedirect("http://localhost:9999/LoginLogout/Retry.html");
		}
		
	}

}
