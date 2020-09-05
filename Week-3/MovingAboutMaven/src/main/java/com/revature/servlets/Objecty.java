package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Planet;


public class Objecty extends HttpServlet {
	
	/*
	 * An Object Mapper will allow us to parse JSON into Java objects and Java objects back into JSON.
	 * 
	 * We use Jackson as our dependency of choice to parse our objects. Other dependencies can be used to achieve 
	 * 	similar effects.
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Instantiate a Object Mapper
		ObjectMapper om = new ObjectMapper();
		
		/*
		 * The JSON object we will parse through must correspond to our Java project. 
		 * 
		 * i.e. Our Java object contains a single property, "name"
		 * 		Our JSON message is : {"name":"Pluto"}
		 * 
		 * 
		 */
		
		//Here we are parsing our JSON message into a Java object
		Planet p1 = om.readValue(request.getReader(), com.revature.models.Planet.class);
		
		//Here we are parsing our Java object back into JSON.
		response.getWriter().write(om.writeValueAsString(p1));
		
		
		
	}

}
