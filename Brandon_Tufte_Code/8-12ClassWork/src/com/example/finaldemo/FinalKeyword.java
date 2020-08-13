package com.example.finaldemo;

public class FinalKeyword {

		/*
		 * a final variable cannot had its value changed after assignment
		 * a final method cannot be overridden
		 * a final class cannot be extended
		 */
	
	public static void main(String[] args) {
		final int CONSTANT_INT = 2;				// final should be labeled by all caps
		
//		CONSTANT_INT = 4;						// causes error,  a final cannot be reassigned cause 
//		System.out.println(CONSTANT_INT += 4);	// causes error,  a final cannot be reassigned cause
		
		
	}
}
