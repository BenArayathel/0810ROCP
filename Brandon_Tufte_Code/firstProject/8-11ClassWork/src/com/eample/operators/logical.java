package com.eample.operators;

public class logical {

	public static void main(String[] args) {
		/*
		 * Logical operators
		 * 
		 * &&	returns true if both statements are true
		 * ||	returns true if either statement is true
		 * !	not
		 * 
		 * bitwise operators
		 * 
		 * &	
		 * |	
		 * 
		 */
		int x = 0;
		int y = 1;
				
		if(++x > 1 | y-- > 2)
			System.out.println("either is true");
		else
			System.out.println("neither is true");
		System.out.println(x);
		System.out.println(y);
	}
}
