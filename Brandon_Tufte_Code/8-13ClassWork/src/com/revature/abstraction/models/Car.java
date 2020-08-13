package com.revature.abstraction.models;

public abstract class Car {

	private double fuelTank;
	private String makeAndModel;
	
	public void brake() {
		
	}
	
	public abstract void drive(); // abstract methods do not have bodies, they are implemented in all child classes
		
	
}
