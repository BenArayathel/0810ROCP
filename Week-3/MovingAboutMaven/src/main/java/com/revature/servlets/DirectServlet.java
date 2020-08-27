package main.java.com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Planet;


public class DirectServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet Direct ");
		
		
		
		response.setContentType("text/html"); //This is unnecessary, because by default the content is text/html
		
		//For a direct response we can directly send a string that can be interpreted as an html file
		//1) We have to instantiate a PrintWriter object from the response object
		//2) We use the .write() method to send strings back. 
		
		PrintWriter pw = response.getWriter();
		
		String myPlanet = "pluto";
		
		pw.write("<h1>Welcome to my get method, I'm sending a direct response back</h1>");
		pw.write("<h2> This is not really a planet " + myPlanet + " </h2>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside post of direct");
		doGet(request, response);
		
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Planet p = new Planet();
	}

}
