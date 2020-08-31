package com.example.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IndirectServlet
 */
public class IndirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndirectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Redirecting
		 * 
		 * 2 requests and 2 responses
		 * client is aware of the external resource
		 */
		
		response.sendRedirect("https://www.google.com/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post Method, forwarding");
		
		/*
		 * Forwarding
		 * 1 request and 1 response
		 * client is unaware of the new resource
		 */
		
		RequestDispatcher redir = request.getRequestDispatcher("/DirectServlet");
		
		redir.forward(request, response);
		
	}

}
