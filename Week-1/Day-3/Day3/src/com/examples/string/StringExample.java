package com.examples.string;

public class StringExample {
	
	/*
	 * String is an object that contains an array of characters. It allows you to create and manipulate
	 * strings. 
	 * 
	 * the String class is immutable and the class is final.
	 * 	immutable : strings cannot be changed
	 * 	final: the class cannot be extended
	 */
	
	public static void main(String[] args) {
		
		String s1 = "This is a String Literal";
		String s2 = new String("This is a String Literal");
		String s3 = "This is a String Literal";
		
//		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s1 == s3);
//		System.out.println(s1.equals(s2));
		
		/*
		 *  == : comparing memory space 
		 *  .equals();
		 */
		
//		String s2 = new String("This is another string");
		
		/*
		 * String literals are stored in the string pool, which is also stored in the heap
		 * 
		 * When a new String "Object" is created, it checks to see if the String pool already has 
		 * the String literal value. If yes, then it points to the value, if not, then it creates a 
		 * new instance, in the String pool. 
		 */
		
		
		String s4 = "Hello there";
		System.out.println(s4.charAt(2));
		System.out.println(s4.length());
		System.out.println(s4.substring(3,7));
		s4 = s4.toUpperCase();
		System.out.println(s4);
		
		System.out.println("another string");
		
	
		
		
	}

}
