package com.revature;

public class MainDriver {
	
	
	/*
	 * Inheritance:
	 * 		Inherits all the properties and methods from parent classes
	 * 		Lets you minimise redundancy (promotes more core reusue)
	 * 
	 * For homogenous inheritance we use the keyword: "extends"
	 * 		class -> class 
	 * 		abstract class -> class
	 * 		abstract class -> abstract class
	 * 		class -> abstract class 
	 * 		interface -> interface
	 * 
	 * For heterogeneous inheritance, we use the keyword: "implements"
	 * 		interface -> class 
	 * 
	 * 	A -> B -> C  "C IS-A B, C IS-A A" 
	 * 
	 * 	C will have access to the methods and variables in B and A (as long as it protected or public)
	 * 	B will have access to methods and variable in A 
	 * 
	 * 	
	 * Diamond Problem:
	 * 		If Java did allow multiple classes, and both parent classes shared method signature
	 * 		the child class would not know which version to pick. 
	 * 
	 * 		With interface, because none of the methods are concrete, we don't have to deal with 
	 * 		this issue. 
	 * 
	 * 		However since Java 8, we've been given the option to create a concrete method in interfaces
	 * 		"default" 
	 * 
	 * 		We resolve it by, specifying which method to pick with the "super" keyword.  
	 * 
	 */
	
	public static void main(String[] apples) {
		
	}

}
