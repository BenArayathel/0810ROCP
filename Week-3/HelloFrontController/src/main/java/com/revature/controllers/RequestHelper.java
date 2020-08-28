package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println(request.getRequestURI());
		
		String s = request.getRequestURI();
		
		switch(s) {
		case "/HelloFrontController/api/login":
			LoginController.login(request,response);
			break;
			
		case "/HelloFrontController/api/logout":
			LoginController.logout(request,response);
			break;
			
		case "/HelloFrontController/api/home":
			HomeController.getHomePage(request,response);
			
			//BrandNewWayBetterHomeController.login()
			break;
			
		case "/HelloFrontController/api/failedlogin":
			HomeController.getFailedLoginPage(request, response);
		
		default:
			HomeController.getLoginPage(request,response);
			break;
			
		}
		
		
	}

}
