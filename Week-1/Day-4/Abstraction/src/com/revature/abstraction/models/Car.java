package com.revature.abstraction.models;

public abstract class Car {
	
	private double fuelTank;
	private double speed;
	private String makeAndModel;
	
	
	public void brake() { //concrete method
		//I'm doing my own logic 
	}
	
	public abstract void drive(); //abstract methods do not have bodies.
	
	public abstract double fillUpTank();
	
	//any class that is a child of car, will have 
	// to implement it for us.

}
