package com.revature;

import com.revature.overloading.Calculator;

public class MainDriver {
	
	/*
	 * Polymorphism
	 * 		Having many forms. From inheritance we're allowed to reuse code 
	 * 		implemented by parent classes. But we can also use the same methods 
	 * 		to complete different Actions.
	 * 
	 * Overriding:
	 * 		Using the same method signature of the parent class but with different
	 * 		implementation. 
	 * 
	 * 		RUN TIME POLYMORPHISM (dynamic polymorphism)
	 * 
	 * 		Only applicable to inherited methods. 
	 * 		NOTE: SAME LEVEL METHODS and CONSTRUCTORS cannot be overridden.
	 * 
	 * Overloading:
	 * 		Same method name, different parameters. 
	 * 
	 * 		Compile time polymorphism (static polymorhpism)
	 * 
	 * 		Changing the number of argumentsd
	 * 		Changing the type of arguments
	 * 		Changing the order of arguments
	 * 
	 * 		NOTE: Can be applied to same level methods and CONSTRUCTOR
	 * 		
	 */
	
	public static void main(String[] oranges) {
		
//		Calculator c = new Calculator(4.0,5.0);
		
		System.out.println(Calculator.add(1.0, 1.0, 1.0));
		
//		System.out.println(Calculator.add(1, 1,1));
		
//		System.out.println(Calculator.stringy("hello",2));
		
//		System.out.println(Calculator.stringy(2, "hello"));
	}

}
