package com.example.model;

import com.example.scopes.MainDriver;

public class DemoObject {
	
	public int a;
	public String b;
	
	public DemoObject(){
		
	}
	
	public DemoObject(int a, String b){
		this.a = a;
		this.b = b;
	}
	
	public void myMethod() {
		String a = MainDriver.myVariable;
	}
	
	@Override //Annotations provide meta data to the JVM. @Override will tell the JVM the following method should be overriding a parent method
	public void finalize() throws Throwable{
		System.out.println("Getting ready for destruction");
	}

}
