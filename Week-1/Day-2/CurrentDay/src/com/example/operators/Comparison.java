package com.example.operators;

public class Comparison {
	
	//Comparison Operators
	// == : check whether they are equal 
	// != : check whether they're not equal
	// > : greater than
	// < : less than 
	// >= : greater than or equal to
	// <= : less than or equal to 
	
	//boolean expression is evaluated, when a comparison operator is used
	// 7 >= 2 -- evaluate to true
	
	public static void main(String[] args) {
		
		int i = 7; //pass by value 
		int j = i;
		
		int[] iArray = {1,2};
		int[] jArray = iArray; //pass by reference 
		
		jArray[0] = 2;
		
		if((i+=1)>0) {
			System.out.println(i);
		}
		
		System.out.println(i);
		
		boolean k = true ;
		
		if(i > 2) {
			//value of i will not change
		} else if( i + 1 > 2) {
			//value of i will not change
		} else if( i++ > 2) {
			//value of i will change after the evaluation 
		} else if( ++i > 2) {
			//value will change before the evaluation
		} else if ( k = (1 > 2) ) {
			// true == false
			// false
			//this will allow us to change the value, and then evaluate the boolean expression
		} else if ( (i += 4) > 2) {
			// 1>2 --- true
		}
		
		
		
		
//		System.out.println(i);
		
//		for(int k: iArray) {
//			System.out.println(k);
//		}
//		
//		for(int l: jArray) {
//			System.out.println(l);
//		}
		
	}
	

}
