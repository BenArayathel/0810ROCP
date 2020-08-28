package com.revature.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * Task:
 * Task: I want you to get the path you requested e.g. : 
 * Front/apples/api/1/2/3/Split that up into a String array :
 *  [Front, apples , api, 1, 2, 3]
 * 
 * 
 */
public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println(request.getRequestURI());
		
		String[] s = request.getRequestURI().split("/");
		
		for (String string : s) {
			if(!string.equals("")) {
				System.out.println(string);
			}
		}
	}
}
