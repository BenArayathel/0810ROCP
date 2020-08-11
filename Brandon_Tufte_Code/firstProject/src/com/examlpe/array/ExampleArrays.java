package com.examlpe.array;

public class ExampleArrays {
	
	
	
	public static void main(String []args) {
		//array is an iterable storage structure
		//same data type
		//iterated by an index
		int[] intArray = new int[10];
		int[] intArray2 = {1,2,3,4,5};
		
		char[] charArray = new char[10];
		char[] charArray2 = {'a','b','c','d','e'};
		
		System.out.println(intArray[0]); //0
		System.out.println(intArray2[0]); //1
		
		intArray[0] = 99; //99
//		intArray[0] = 100.7; //double cannot be put in int
		intArray[0] = (int)100.7; //100
		intArray[0] = 'z'; //122
		
		for(int i=0; i < intArray2.length; i++) {
			System.out.println(intArray2[i]);
			
		}		

		for(int i=intArray2.length-1; i >= 0 ; i--) {
			System.out.println(intArray2[i]);
		}
		
		for(int i: intArray2) {
			System.out.println(i); //implemented through the index
		}
		
		
	}
}
