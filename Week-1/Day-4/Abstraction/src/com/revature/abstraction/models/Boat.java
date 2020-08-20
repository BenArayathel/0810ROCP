package com.revature.abstraction.models;

public interface Boat {
	
	//Can't have any concrete method 
	//Cannot be instantiated, does not have a constructor
	//Child classes must implement all the methods (otherwise declared as abstract)
	
	double[] NORTH_STAR = {0,0}; //public static final
	double PI = 3.14;
	
	public default void sail() {
		System.out.println("boating about");
	}
	
	public abstract void dock();
	
	public default void stop() {
		System.out.println("Please stop");
	}
	
	
	
	

}
