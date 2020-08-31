package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		request.getMethod();
		System.out.println("In the hello!");
		response.getWriter().write("Hello! I'm in the controller!");
	}

}
