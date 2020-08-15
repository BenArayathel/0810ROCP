package com.example;

import com.example.customException.RocketFailuer;

public class AnotherDriver { //A chain of methods that keep passing responsibilty
	
	public static void method() throws Exception{
		method1();
	}
public static void method1() throws Exception{
		method2();
	}
public static void method2() throws Exception{
	method3();
	
}
public static void method3() throws Exception{ //RocketFailure is a RuntimeException. Do I actually need to handle it everywhere? 
	throw new RocketFailuer();
}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		method1();
	}

}
