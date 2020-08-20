package com.example.classes.car.models;

public class Car {
	
	//states of an object, states don't have to be defined when a class is instantiated.
	public boolean hasEngine;
	public int wheels;
	private String makeAndModel;
	
	/*	Objects can be stored within an object, this is a "HAS-A" relationship
	 * 	Once again, these properties don't have to be initialized during object instantiation 
	 */
	public Seatbelt mySeatbelt = new Seatbelt();
	private Seat seats;
//	private AirCon ac;
//	private Window windows;
	
	
	
	public char run() {
		System.out.println("Engine is running");
		return 'a';
	}
	
	public int wheelCheck() {
		System.out.println("Doing a wheel check");

		System.out.println("There are " + this.wheels + " wheels"); //	Keyword "this" will reference an object's own properties 
		
		return this.wheels;
	}
	
	public void crash() {
		
		this.mySeatbelt.safetyProtocol(); //inside a method, another object's method can be invoked
		System.out.println("Minor crash");
		
		crash(true, 2); //if the method exists inside the same object, there is no need to reference the object
	}
	
	public void crash(boolean engineStatus, int numberOfWheels) {
		System.out.println("system failure");
		this.hasEngine = engineStatus;
		this.wheels = numberOfWheels;
	}
	

}
