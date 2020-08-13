package com.eample.scopes;

public class MainDriver {

	public int myVariable;
	
	public void myMethod() {
		int myVariable; //can be done cause in method
		this.myVariable = 2;
		int methodVariable;
		
		for(int i=0; i<4; i++) {
//			int myVariable; // cant be done cause in block
			this.myVariable = 1;
			methodVariable = 2;
		}
//		i = 4; //out of scope
	}
	
	
	
	public void anotherVaiable() {
		int myVariable;
	}
	
	public static void main(String[] args) {
		/*
		 * Scope - area where an object exists
		 * 
		 * Types od scope - Class -> Method -> Block
		 * 
		 * 
		 */
		
		
	}
}
