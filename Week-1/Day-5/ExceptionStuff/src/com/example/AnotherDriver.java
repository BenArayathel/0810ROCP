package com.example;

import com.example.customException.RocketFailuer;

public class AnotherDriver {
	
	public static void method() {
		method1();
	}
public static void method1() {
		method2();
	}
public static void method2() {
	method3();
	
}
public static void method3() {
	throw new RocketFailuer();
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}

}
