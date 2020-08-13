package com.revature.polymorphism.models;

public class Calculator {
	
	private double pi;
	private int e;
	private double h;
	
	public Calculator() {
		this(3.1,2.1,1);
	}
	
	public Calculator(double pi) {
		this.pi = pi;
	}

	public Calculator(double pi, double h) {
		this.pi = pi;
		this.h = h;
	}
	
	public Calculator(double pi, double h, int e) {
		this.pi = pi;
		this.h = h;
		this.e = e;
	}
	
	public double add (double x, double y) {
		return x + y;
	}
	public double add (double x, double y, double z) {//Overload by number of parameter
		return x+y+z;
	}
	public double add (int x, int y) {//overload by type of parameter
		return x + y;
	}
	
	
	public String word(String s, int i) {
		return s+i;
	}
	public String word(int i,String s) {//overload by changing order of parameter
		return s+i;
	}
}
