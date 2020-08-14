package com.example;

public interface Boat {
public double pi=3.14;
public  void hasRadar();
public void hasSteeringWeel();
public boolean hasEngine();
public default boolean hasSailer() {
return true;
}


public class SpeedBoat implements Boat{

	@Override
	public void hasRadar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hasSteeringWeel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasEngine() {
		// TODO Auto-generated method stub
		return false;
	}
	
}