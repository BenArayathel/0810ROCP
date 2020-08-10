package com.example.controlflow;

public class SwitchExample {
	
	//Switch will compare expression to see if they match. 
	
	public static void main(String[] args) {
		
		int myNumber = 7; //an example comparing numbers
		
		switch(myNumber) { //switch will compare variables 
			case 1: //once a condition is met will keep executing all statements 
				
				System.out.println("first expression met");
				break; //break will exit the switch loop 
				
			case 7:
				System.out.println(" your number is 7");
				break;
			case 37:
				System.out.println(" the number is not 37");
			default://will execute if none of the other cases have been met 
				
				System.out.println("Welcome to default");
				
			
		}
		
		
		
		char myChar = 'z'; // an example comparing char
		
		switch(myChar) {
			case 'a':
				System.out.println("character is a");
			case 'z':
				System.out.println("character is z");
		}
	}

}
