package com.example.customException;

public class RocketFailuer extends RuntimeException {
	
	@Override
	public String toString() {
		return "The Rocket failed";
		
	}

}
