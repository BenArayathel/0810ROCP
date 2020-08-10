package com.example.controlflow;

public class IfandElse {
	
	/*
	 * if statements will evaluate a condition to decide whether to execute 
	 * a piece of code. All other statements will not execute
	 */
	
	public static void main(String[] args) {
		
		int newVariable = 6;
		
		if (newVariable < 7) { 
			//will print out variables if newVariable is less than 7
			System.out.println(newVariable);
		} else if(newVariable < 12) {
			//will print String if the first condition hasn't been met and the condition
			//inside the else if is met
			System.out.println("the number is under 12");
		} else {
			//will execute if no other statements have been met
			System.out.println("it's not less than 12");
		}
		
	}

}
