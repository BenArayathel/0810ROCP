package com.example.classes;

import com.example.human.models.Human;

public class Driver {
	
	//Class is a logical entity
	//Objects are a physical entity
	
	public static void main(String[] args) {
		
		Car myCar = new Car();
		System.out.println(myCar.hashCode());

		myCar.hasEngine = true;
		myCar.wheels = 4;
		myCar.makeAndModel = "Tesla model x";
		
		System.out.println(myCar.hasEngine);
		System.out.println(myCar.wheels);
		System.out.println(myCar.makeAndModel);
		
		/*
		 * Function - takes in arguements, executes logic, returns value
		 * Procedure - takes in arguements, executes logic, does not return a value
		 * Method - function associated with and object
		 * Contructor doesn't have a return type, JVM creats a constuctor if none exists
		 */
		myCar.crash(false, 2);
		
		Human dude = new Human();
		dude.name = "theDude";
//		dude.weight = 170;
		dude.setWeight(170);
		dude.getWeight();
		System.out.println(dude.getWeight());
	}
}
