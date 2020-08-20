package com.revature.overloading;

public class Calculator {
	
	private double pi;
	private int e;
	private double h;
	
	public Calculator() {
		this(3.14);
		System.out.println("Inside no-args");
		
	}
	
	public Calculator(double pi) {
		this(pi, 1.0);
		System.out.println("Inside single argument");	
	}
	
	
	public Calculator(double pi, double h) {
		//super()
		this(pi, 1, h);
		System.out.println("Inside double argument");
		
	}
	
	public Calculator(double pi, int e, double h) {
		super();
		System.out.println("Inside all args");
		this.pi = pi;
		this.e = e;
		this.h = h;
	}
	
	
	public static double add(double x, double y) {
		return x+ y;
	}
	
	public static double add(double x,double y, double z) { //changing the number of parameters
		System.out.println("Hang on you put 3 numbers, thats illegal ");
		
		return x+y+z;
	}
	
//	public static void isObject() {
//		
//	}
	
	public static void isObject(Demo obj) {
		
	}
	
	
	public static double add(double... x) { //var-args
		System.out.println(x);
		
		double z = 0;
		
		for(double i: x) {
			z += i;
//			System.out.println(i);
		}
		
		return z;
	}
	

//	public static double add(int x, int y) { //changing the datatype is another way
//		System.out.println("Inside int method");
//		return x + y;
//	}
	
	public static String stringy(String s, int i) {
		return s + i;
	}
	
	public static int stringy(int i, String s) { //change the order
		return 0;
	}
	
	
	
}
