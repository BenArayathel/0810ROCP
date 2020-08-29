package com.kash.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RequestHelper {
public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	
		String s = request.getRequestURI();
		System.out.println(s);
		
		
		/*
		System.out.println("asg: ");
		String[] str = s.split("/");
		for (String i : str) {
			System.out.println(i);
		}
		*/
		switch(s) {
			case "/FinalProjectV1/api/login":
				LoginController.login(request,response);
				break;
				
			case "/FinalProjectV1/api/logout":
				LoginController.logout(request,response);
				break;
				
			case "/FinalProjectV1/api/home":
				HomeController.getHomePage(request,response);				
				break;
				
			case "/FinalProjectV1/api/failedlogin":
				HomeController.getFailedLoginPage(request, response);
			
			default:
				HomeController.getLoginPage(request,response);
				break;
			
		}
		
		
	}
}
