package com.example.customException;

public class RocketFailuer extends RuntimeException { //This is a way of creating a custom exception 
	
	
	//We override the appropriate Exception class we want. 
	//Exceptions can be chained: Exception -> RuntimeException -> RocketFailuer -> (try making your own here)
	
	@Override
	public String toString() {
		return "The Rocket failed";
		
	}

}
