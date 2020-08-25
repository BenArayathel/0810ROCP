package com.revature;

import com.revature.abstraction.models.AirBoat;
import com.revature.abstraction.models.Car;
import com.revature.abstraction.models.MathematicalConstants;
import com.revature.abstraction.models.Scooter;
import com.revature.abstraction.models.SuperCar;
import com.revature.abstraction.models.Truck;

public class MainDriver {
	
	/*
	 * Abstraction is another pillar of OOP 
	 * 
	 * The concept of hiding implementation to show functionality. 
	 * 
	 * *I can use a phone, without knowing how to make a phone
	 * *I can drive a car, without knowing how the engine works. 
	 * 
	 * Abstract classes (partial abstraction) and Interfaces (complete abstraction)
	 * 
	 * Abstraction is a contract. 
	 * 
	 * Abstract classes cannot be final.
	 * Abstract classes cannot be static. 
	 */
	
	public static void main(String[] args) {
		
		
		/* Car -> SuperCar
		 * Car -> Truck -> Boat 
		 * Car -> Scooter 
		 * Car -> Boat
		 * Boat -> Car
		 * 
		 * c -> c
		 * c -> ac -> c
		 * ac -> ac -> c
		 * 
		 * ac -> ac 
		 * 
		 * c -> ac -> c -> ac -> c 
		 * 
		 * class -> abstract class
		 */
		
		//our logic
		
		Car myCar = new Scooter();
		Car myCar1 = new SuperCar();
		Car myCar2 = new Truck();
		
//		Car myBoat = new Boat();
		
//		System.out.println(MathematicalConstants.e);
		
		Car[] garage = {myCar, myCar1, myCar2};
		
		AirBoat ab = new AirBoat();
		ab.sail();
		
		
		/*
		 * INTERFACES:
		 * 		Cannot have any concrete methods (all abstract methods) 
		 * 
		 * 		Methods by standard are abstract and public 
		 * 
		 * 		Variables are public , static and final 
		 * 
		 * 		An interface cannot have a constructor 
		 * 
		 * 		Implement multiple interfaces, can only extend a class at a time.
		 * 
		 * 
		 */
		
	}

}
