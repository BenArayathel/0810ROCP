package com.revature.abstraction.models;

public interface Airplane {
	
	public default void sail() {
		System.out.println("I'm flying, but in the sea");
	}

}
