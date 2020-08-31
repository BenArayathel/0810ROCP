package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String uri = request.getRequestURI();
		
		System.out.println(request.getMethod());
		
		System.out.println(uri);
		
		String[] uriParts = uri.split("/");
		
		for (String part:uriParts) {
			System.out.println(part);
		}
		
		System.out.println(uriParts[3]);
		
		switch (uriParts[3]) {
		case "hello":
			HelloController.process(request, response);
			break;
		
		
		}
	}

}
