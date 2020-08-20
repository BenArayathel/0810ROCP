package com.example.classes;

import com.example.classes.car.models.Car;
import com.example.classes.car.models.Seatbelt;
import com.example.classes.human.models.Brain;
import com.example.classes.human.models.Human;

public class Driver {
	
	// The class with main method will be typically called the "Driver" or the "MainDriver"
	
	/*	Class is a logical entity
	 * 	Objects are a physical entity 
	 * 	e.g. "Human" is a class, "steve" is an instance of an human - an object. 
	 * 	
	 * 	Class is a template or a blueprint, it will define what the states and the methods an object will have. 
	 * 
	*/
	
	/*
	 * Terminology:
	 * 
	 * Functions : takes in arguments, executes logic, returns a value
	 * Procedures : takes in arguments, executes logic, does not return a value
	 * Methods : is a function, associated with an object. 
	 */
	
	public static void main(String[] args) {
		

		/* We define 2 new car object, assigning each to a reference variable
		 * 
		 * NOTE: Every time we use the 'new' keyword, we create a new Object in memory
		 */
		
		Car myCar = new Car();
		Car anotherCar = new Car();
		
		/*
		 * Car has 4 properties: hasEngine, wheels, makeAndModel, mySeatBelt
		 * 		
		 * NOTE: makeAndModel will cause an error, because we set it to be private
		 */
		
		myCar.hasEngine = true;
		myCar.wheels = 4;
//		myCar.makeAndModel = "Tesla model y";
		myCar.mySeatbelt = new Seatbelt();
		
//		System.out.println(myCar.hasEngine);
//		System.out.println(myCar.wheels);
		
//		char charVariable = myCar.run();
//		System.out.println(myCar.run());
		
		
//		anotherCar.wheels = 3; //properties are not immutable, can be reassigned an appropriate value
		
		
//		System.out.println(myCar.hashCode()); //This method will return a hashcode
		
		/*
		 * NOTE: hashing is applying a hash function to data (a mathematical function)
		 */

//		System.out.println(anotherCar.wheelCheck());
		
//		System.out.println(myCar.wheels);
//		System.out.println(myCar.hasEngine);
//		
//		myCar.crash(true, 1); 	//method invocation depends on name and parameters
//		myCar.crash();  		//methods with same name and different parameters are allowed. 
//		
//		System.out.println(myCar.wheels);
//		System.out.println(myCar.hasEngine);
//		
//		System.out.println();
		
		
		
		//Static states do not need an object instance, they are directly associated with a class 
		Human.setPi(3); //We're setting the static value of pi, of class Human, to 3
		
		
		Human vinay = new Human("vinay",170,new Brain()); 	//Constructor overloading, different constructors are invoked depending on arguments
		Human ben = new Human();
		Human steeve = new Human();
		
		System.out.println(ben.getPi());
		System.out.println(steeve.getPi());
		
		
	}

}
