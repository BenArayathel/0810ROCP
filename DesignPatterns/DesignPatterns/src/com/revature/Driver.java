package com.revature;

import com.revature.models.Car;

public class Driver {

	public static void main(String[] args) {
		/*
		 * I only want a single instance of a car
		 * 
		 * We use a singleton design pattern, private constructors and a public static method.
		 */
		
		Car a = Car.giveMeACar();
		Car b = Car.giveMeACar();
		Car c = Car.giveMeACar();
		
		c.setFuel(50);
		
		System.out.println(a.getFuel());
		
//		Car d = new Car();

	}

}
