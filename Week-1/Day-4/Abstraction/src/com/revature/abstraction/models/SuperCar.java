package com.revature.abstraction.models;

public class SuperCar extends Car{
	
	@Override
	public void drive() {
		System.out.println("Driving really fast");
	}

	@Override
	public double fillUpTank() {
		// TODO Auto-generated method stub
		return 0;
	}

}
