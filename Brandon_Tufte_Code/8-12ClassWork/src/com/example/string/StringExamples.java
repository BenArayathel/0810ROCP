package com.example.string;

public class StringExamples {

	/*
	 *String is an object that contains a array of characters 
	 *allows for creation and manipulation of strings
	 *
	 *the String class is immutable and final
	 *immutable - cannot be changes
	 *final - cannot be extended
	 *
	 *string literals are stored in the string pool, which is in the heap
	 *
	 *when a string is initialized with a string already engaged in the string pool, it simply points to the current string
	 */
	
	public static void main(String[] args) {
		
		String text = "This is a String Literal";
		String text2 = new String("This is a String Literal"); // creates a new string in the pool regardless of similarity 
		String text3 = "This is a String Literal"; // text and text3 point to the same string in the string pool
		
		System.out.println(text);
		System.out.println(text2);
		System.out.println(text == text2);
		System.out.println(text.equals(text2));
		
		text3 = "This is another String"; //This creates a new string in the string pool, not change the current string
		
		//String functions - none will change the content of variable
		System.out.println(text3.charAt(2)); // char at location 3
		System.out.println(text3.length()); // count the characters in string
		System.out.println(text3.substring(3, 7));
		System.out.println(text3.toUpperCase()); // reports the string in all upper case
		System.out.println(text3 + 5 +7); // appends 5 then 7 to the end of string
		
	}	
}
