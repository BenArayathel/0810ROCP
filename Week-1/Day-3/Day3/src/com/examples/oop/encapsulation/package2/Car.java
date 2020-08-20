package com.examples.oop.encapsulation.package2;

public class Car {
	
	private double fuel;
	private int wheels;
	private String makeAndModel;
	private boolean heatedSeats;
	
	
	
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(double fuel, int wheels, String makeAndModel, boolean heatedSeats) {
		super();
		this.fuel = fuel;
		this.wheels = wheels;
		this.makeAndModel = makeAndModel;
		this.heatedSeats = heatedSeats;
	}

	public double getFuel() {
		return fuel;
	}

	public void setFuel(double fuel) {
		this.fuel = fuel;
	}

	public int getWheels() {
		return wheels;
	}

	public void setWheels(int wheels) {
		this.wheels = wheels;
	}

	public String getMakeAndModel() {
		return makeAndModel;
	}

	public void setMakeAndModel(String makeAndModel) {
		this.makeAndModel = makeAndModel;
	}

	public boolean isHeatedSeats() {
		return heatedSeats;
	}

	public void setHeatedSeats(boolean heatedSeats) {
		this.heatedSeats = heatedSeats;
	}

	@Override
	public String toString() {
		return "Car [fuel=" + fuel + ", wheels=" + wheels + ", makeAndModel=" + makeAndModel + ", heatedSeats="
				+ heatedSeats + "]";
	}
	
	
	
	

}
