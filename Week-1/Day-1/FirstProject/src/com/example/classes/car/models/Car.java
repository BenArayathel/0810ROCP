package com.example.classes.car.models;

public class Car {
	
	public boolean hasEngine;
	public int wheels;
	private String makeAndModel;
	public Seatbelt mySeatbelt = new Seatbelt();
	
	//store objects
	private Seat seats;
//	private AirCon ac;
//	private Window windows;
	
	public char run() {
		System.out.println("Engine is running");
		return 'a';
	}
	
	public int wheelCheck() {
		System.out.println("Doing a wheel check");

		System.out.println("There are " + this.wheels + " wheels");
		
		return this.wheels;
	}
	
	public void crash() {
//		Seatbelt sb = new Seatbelt(); // create a new seatbelt 
//		sb.safetyProtocol(); // calling on the method
		
//		this.mySeatbelt.safetyProtocol();
		
		System.out.println("Minor crash");
		
		crash(true, 2);
	}
	
	public void crash(boolean engineStatus, int numberOfWheels) {
		System.out.println("system failure");
		this.hasEngine = engineStatus;
		this.wheels = numberOfWheels;
	}
	

}
