package com.revature.abstraction.models;

public class Scooter extends Car{
	
	public Scooter() {
		
	}
	
	public Scooter(String s) {
		
	}

	@Override
	public void drive() {
		System.out.println("turning corner really quick");
		
	}

	@Override
	public double fillUpTank() {
		// TODO Auto-generated method stub
		return 0;
	}

}
