package com.revature.models;

public class Car {
	
	private String name;
	private double fuel;
	private static Car car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getFuel() {
		return fuel;
	}
	public void setFuel(double fuel) {
		this.fuel = fuel;
	}
	
	public static Car giveMeACar() {
		
		if(car == null) {
			car = new Car();
		}
		
		
		
		return car;
		
	}
	
	private Car(String name, double fuel) {
		super();
		this.name = name;
		this.fuel = fuel;
	}
	
	private Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", fuel=" + fuel + "]";
	}
	
	

}
