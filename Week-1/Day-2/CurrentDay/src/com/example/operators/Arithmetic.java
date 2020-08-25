package com.example.operators;

public class Arithmetic {
	
	public static void main(String[] oranges) {
		
		// Arithmitic operators (x,y)
		// + : addition
		// - : subtraction
		// * : multiplication
		// / : division 
		
		int a = 2+2;
		int b = a + a + 2; //10
		b = b - (b + b) ; //10
		
//		System.out.println(b);
		
		int c = 3*7; //21
		c = 7/3; 
//		System.out.println(c);
		
		double d;
		d = 7/3.0; 
//		System.out.println(d);
		
		float f;
		f = (float) (7/3.0);
//		System.out.println(f);
		
		// %: Modulo operator
		
		double e;
		e = 7%2.5;
//		System.out.println(e);
		
		double g;
		g = Math.pow(7, 2); //49
//		System.out.println(g);
		
		
		//(x) operators
		// ++ : increment, increase value by 1
		// -- : decrement, decrease value by 1
		
		g++;
		
//		System.out.println(++g);
//		System.out.println((g++));
//		System.out.println(g);
		

	}

}
