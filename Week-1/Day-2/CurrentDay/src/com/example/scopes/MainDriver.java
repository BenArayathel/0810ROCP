package com.example.scopes;

/*
 * What is a scope?
 * 		An area where a variable exists during its lifetime
 * 
 * 
 * Types of scopes:
 * 		
 * 		Class scope
 * 		Method scope 
 * 		Block (Loop) scope
 * 
 * 
 * 
 * Block is the most narrow scope and consist of 
 * 
 */

public class MainDriver {
	
	public static String myVariable = "This can be used anywhere in the class";
	
	public void myMethod() {
		this.myVariable = "2";
		int myVariable;
		int methodVariable;
		
		for(int i = 0; i <4; i++) {
			int k = 1;
			this.myVariable = "1";
			methodVariable = 2;
			
		}
		
		for(int i = 0; i < 4; i++) {
			
		}
		
//		k = 3;
		
	}
	
	public void anotherMethod() {
		int methodVariable;
		this.myVariable = "new string";
	}
	
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
	}

}
