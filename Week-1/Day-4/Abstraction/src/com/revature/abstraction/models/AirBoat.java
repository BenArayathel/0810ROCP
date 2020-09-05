package com.revature.abstraction.models;

public class AirBoat extends Car implements Boat, Airplane{

	@Override
	public void sail() {
		
		Airplane.super.sail();
		Boat.super.sail();
		
	}

	@Override
	public void dock() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drive() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double fillUpTank() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
}
