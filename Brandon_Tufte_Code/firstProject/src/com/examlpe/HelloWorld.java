package com.examlpe;

public class HelloWorld {
	/*
	 * Java syntax typing
	 * Class: Titlecase
	 * Method: camelCase
	 * variable: camelCase
	 * package: lowercase
	 */
	//Main Method
	public static void main(String []args) {
		System.out.println("Hi Earth");
		/*Primitive data type
		 * int - 32bit
		 * byte - 8bit
		 * char - 16bit
		 * boolean - 1Bit
		 * long - 64Bit
		 * short - 16Bit
		 * float - 32Bit
		 * double - 64Bit
		*/
		int one; //declaration
		one = 2; //assingment
		one = 1; //Reassignment
//		one = true;
//		one = 32.1;		
		boolean bool = true; //declare and assign		
		double two = 23.1;		
		char letter = 'c';
		
		//Control Flow Statements
		/*
		 * if
		 * switch
		 * do while
		 * while
		 * for
		 */
		for(int i=0; i < 5; i++) {
			//declare and initialize and variable
			//conditional statement
			//increment step
			System.out.print("Inside for loop");
			System.out.println(i);
		}
		
		while(one < 8) {
			System.out.print("Inside While loop");
			System.out.println(one);
			one++;
		}
		
		do {
			System.out.print("Inside doWhile loop");
			System.out.println(one);
			one--;
		}while(one > 0);
		
		int var = 9;
		
		if(var < 7) {
			System.out.println(var);
		}
		else if (var < 12) {
			System.out.println("is less than 12");
		}
		else {
			System.out.println("is not less than 12");
		}
				
		switch(letter) {
			case 'a':
				System.out.println('a');
				break;
			case 'b':
				System.out.println('b');
				break;
			case 'c':
				System.out.println('c');
				break;
			default:
				System.out.println("Not a,b, or c");
		}
		
	}
}
