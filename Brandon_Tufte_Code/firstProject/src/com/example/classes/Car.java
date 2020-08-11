package com.example.classes;

public class Car {
	
	public boolean hasEngine; //Property, it has no ()
	public int wheels;
	public String makeAndModel;
	
	//Method
	public void run() {
		System.out.println("Engine is running");
	}
	
	public int wheelCheck() {
		System.out.println("Doing a wheel check");
		System.out.println("There are " + this.wheels + " wheels");
		return this.wheels;
	}
	
	public void crash() {
		System.out.println("MinorCrash");
	}
	
	public void crash(boolean engineStatus, int numberOFWheels) {
		System.out.println("System failure");
		this.hasEngine = engineStatus;
		this.wheels = numberOFWheels;
	}
}
