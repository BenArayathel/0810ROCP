package main.java.com.revature.servlets;

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
	
	/*
	 * There are 2 types of indirect responses 
	 * 
	 * Forwarding :
	 * 		Allows you to navigate to another endpoint within your website (external websites will not work)
	 * 		You only have to provide a portion of the url, not the whole website name.
	 * 		NOTE : CLIENTS WILL NOT BE AWARE THEY HAVE BEEN FORWARDED
	 * 		NOTE : There is a single request and response.
	 * 
	 * Redirecting 
	 * 		Allows you to navigate to any resource on the web (that the client has access to)
	 * 		You have to provide the WHOLE URI
	 * 		NOTE : CLIENT WILL BE AWARE THEY HAVE BEEN REDIRECTED
	 * 		NOTE : THERE ARE 2 REQUESTS AND RESPONSES, A REQUEST FROM THE CLIENT, A RESPONSE FROM THE 
	 * 				SERVER TELLING THE CLIENT TO SEND ANOTHER REQUEST TO THE NEW URL AND A RESPONSE 
	 * 				FROM THE NEW URL. 
	 * 
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * REDIRECTING
		 * 
		 * 2 request and 2 responses. 
		 * Client is aware of the external resource.
		 * 
		 */
		
		response.sendRedirect("https://www.google.com"); //WORKS WITH EXTERNAL RESOURCES 
//		response.sendRedirect("http://localhost:9999/MovingAboutMaven/LandingPage.html"); //ENTIRE URI HAS TO BE SPECIFIED
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside Post method, forwarding.");
		
		/*
		 * FORWARDING
		 * 1 request and 1 response 
		 * Client is UNAWARE of the new resource
		 */
		
		/*
		 * Forwarding requires the RequestDispatcher
		 * 
		 * The RequestDispatcher is an interface that defines an object to be able to handle requests 
		 * 	and dispatch a resource back (servlet or html file) on the server.
		 */
		
		
		RequestDispatcher redir = request.getRequestDispatcher("/DirectServlet"); //THE ENTIRE URI  NO LONGER NEEDS TO BE SPECIFIED.
	
//		RequestDispatcher redir = request.getRequestDispatcher("/LandingPage.html"); // You can also specify html pages as well as servlets.
		
//		RequestDispatcher redir = request.getRequestDispatcher("/https://www.google.com"); //DOES NOT WORK WITH EXTERNAL RESOURCES
		
		redir.forward(request, response);

	}

}
