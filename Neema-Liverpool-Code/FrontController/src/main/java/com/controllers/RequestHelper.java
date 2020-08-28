package com.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * like a table of contents
 */
public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println(request.getRequestURI());
		
		String s = request.getRequestURI();
		
		switch(s) {
		case "/FrontController/api/login":
			LoginController.login(request,response);
			break;
			
		case "/FrontController/api/logout":
			LoginController.logout(request,response);
			break;
			
		case "/FrontController/api/home":
			HomeController.login(request,response);
			break;
	//	fail to login	
		default:
			Home.getLoginPage(request,response);
		break;
		}
	}

	
}
