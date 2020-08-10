package com.example.arrays;

public class ExampleArray {
	
	public static void main(String[] args) {
		
		// an array is a list of items that are iterable
		// same data type 
		// positions are indexed
		
		int[] intArray = new int[10];
		
		
		int[] anotherArray = {5,4,3,2,1};
		
		char[] newCharArray = new char[5];
		
		char[] charArray = {'a', 'c', '3','z'};
		
//		System.out.println(anotherArray[2]);
//		System.out.println(intArray[9]);
		
		intArray[0] = 99;
		intArray[1] = (int) 100.7;
		intArray[2] = 'z';
		
		
//		System.out.println(intArray[2]);
		
//		for(int i = 0; i < anotherArray.length; i = i + 2) {
//			System.out.println(anotherArray[i]);
//		}
//		
//		System.out.println("");
		
//		for(int i = anotherArray.length -1; i > -1; i--) {
//			System.out.println(anotherArray[i]);
//		}
		
//		for(int i: anotherArray) {
//			System.out.println(i);
//		}
		
		
//		Iterating through the char array
		
//		for(int i = 0; i <= charArray.length - 1; i++) {
//			System.out.println(charArray[i]);
//		}
//		
//		System.out.println("");
//		
//		for(char i:charArray) {
//			System.out.println(i);
//		}
		
		for(char i: newCharArray) {
			System.out.print(i);
		}
		
		
		
		
		
		
	}

}
