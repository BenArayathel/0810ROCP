package com.revature;

import com.revature.abstraction.models.Car;
import com.revature.abstraction.models.Scooter;
import com.revature.abstraction.models.SuperCar;
import com.revature.abstraction.models.Truck;

public class MainDriver {
	/*
	 * Abstraction - concept of hiding implementation to show functionality
	 * 
	 * "I know how to use a phone, but not make a phone."
	 * 
	 * abstract class is partial abstraction
	 * interface is complete abstraction
	 * 
	 * Abstract Class - defined by child class
	 * abstract classes cannot be final
	 * abstract classes cannot be static
	 * child classes extend abstract classes
	 * Inheritance line:
	 * 	class -> class -> class
	 * 	abstract class -> class -> class
	 *  class -> abstract class -> class
	 *  abstract class -> class -> abstract class -> class
	 *  abstract class -> abstract class
	 *  
	 *  Interface - 
	 *  cannot have any concert methods, except with default keyword
	 *  default keyword to define methods like regular superClasses, (public default void{name})
	 *  cannot be instantiated, does not have constructors
	 *  child must implement all the methods
	 *  properties are implicitly "public static final"
	 *  child interfaces extend interfaces
	 *  child classes implement interfaces
	 *  can inherit and extend together
	 */
	public static void main(String[] args) {

		Car vehicle1 = new Truck(); //has to be instantiated as a child class like Truck
		Car vehicle2 = new SuperCar();
		Car vehicle3 = new Scooter();
	}
}
