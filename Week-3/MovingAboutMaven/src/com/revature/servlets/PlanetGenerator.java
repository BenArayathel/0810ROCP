package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Planet;


public class PlanetGenerator extends HttpServlet {
	
    /*
     * We use the form tag, as well as Postman to send our requests
     */

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String p;
		
		/*
		 * .getParameter("parameter_name") will return the value of the parameter.
		 */
		String a = request.getParameter("Planet");
		String b = request.getParameter("Apples");
		String c = request.getParameter("Kiwi");
		
		System.out.println(a + " " +  b + " " + c);
		
		Planet pl = new Planet(a);
		
		/*
		 * Pseudo code for what you can do: 
		 * 
		 *  Here we are grabing the userId from the request, passing it into our dao method to call an existing user from our database
		 * 
		 * user u = userDaoImpl.selectById(userId)
		 */
		
		
	
		/*
		 * If we don't pass a parameter value through, the string will be null.
		 * Be careful about NullPointerException
		 */
		if(request.getParameter("Planet") != null) {
			
		/*
		 * If a parameter has been passed through we can then assign it to a variable.
		 */
			p = request.getParameter("Planet");
			
		/*
		 * We're using switch case to decide what we'll be doing with out value
		 */
			
			switch(p.toLowerCase()) {
				case "mercury": //If the value is mercury, we forward the page to another html file
					RequestDispatcher rd = request.getRequestDispatcher("/Success.html");
					rd.forward(request, response);
					break;
				default: //if it's not mecury we redirect back to PlanetGenerator.html file
//					response.sendRedirect("https://www.google.com");
					rd = request.getRequestDispatcher("/PlanetGenerator.html");
					rd.forward(request, response);
					
			}
			
			/*
			 * Psuedo code for what we could do to validate client data
			 * In this case we're checking whether a user id exists in the database. 
			 * 
			 * String id = requestparameter("id");
			 * 
			 * validateId(id);
			 * 
			 * validateId(id){
			 *  user u = 	userIdDao.selectUser(id);
			 *  if(u == null){
			 *  	incorrect user
			 *  }else{\
			 *   	pw.write( welcome u.username())
			 */
			
		}else {
			PrintWriter pw = response.getWriter();
			
			//if no parameter has been passed through, we respond with a direct response. 
			pw.write("Invalid access, make sure you send a planet over here!");
			
			/*
			 * Below is an example of dynamically creating a page.
			 * We are generating a list of transactions based on how many transactions exists in the user's account
			 * 
			 * for(transaction t: totaltrasnactions ) {
			 * pw.write ( <li>Transaction + t.id() occured during + t.date()</li>)
			 */

			
		}
		
		
	}

}
