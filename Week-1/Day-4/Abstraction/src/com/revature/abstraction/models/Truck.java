package com.revature.abstraction.models;

public class Truck extends Car{
	
	@Override
	public void brake() {
		
	}
	
	
	@Override
	public void drive() {
		System.out.println("Carrying a lot of things");
		
	}

	@Override
	public double fillUpTank() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
