package com.revature.util;

public class UnitTestCalculator {
	
	public static int add(int x, int y) {
		return x + y;
	}
	
	public static double multiply(int... x) {
		int a = 1;
		for(int i: x) {
			a = a*i;
		}
		return a;
	}
	
	public static double divide(int x, int y) {
		return x/y;
	}

}
