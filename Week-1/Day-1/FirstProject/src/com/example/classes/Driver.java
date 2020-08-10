package com.example.classes;

import com.example.classes.car.models.Car;
import com.example.classes.car.models.Seatbelt;
import com.example.classes.human.models.Brain;
import com.example.classes.human.models.Human;

public class Driver {
	
	//Class is a logical entitiy 
	//Objects are a physical entity 
	
	
	public static void main(String[] args) {
		
//		Car myCar = new Car();
//		Car anotherCar = new Car();
//		
//		Seatbelt sb = new Seatbelt();
//		anotherCar.wheels = 3;
//		System.out.println(myCar.hashCode());
//		int a =1;
//		a = 1;
//		myCar.hasEngine = true;
//		myCar.wheels = 4;
//		myCar.makeAndModel = "Tesla model y";
//		myCar.mySeatbelt = new Seatbelt();
		
//		System.out.println(myCar.hasEngine);
//		System.out.println(myCar.wheels);
//		System.out.println(myCar.makeAndModel);
//		
//		char charVariable = myCar.run();
//		System.out.println(myCar.run());
		
//		System.out.println(myCar.wheelCheck());
//		System.out.println(anotherCar.wheelCheck());
		
//		System.out.println(myCar.wheels);
//		System.out.println(myCar.hasEngine);
//		
//		myCar.crash(true, 1);
//		myCar.crash();
//		
//		System.out.println(myCar.wheels);
//		System.out.println(myCar.hasEngine);
//		
//		System.out.println();
		
		
		/*
		 * Functions : takes in arguments, executes logic, returns a value
		 * Procedures : takes in arguments, executes logic, does not return a value
		 * Methods : is a function, associated with an object. 
		 */
		
		Human.setPi(3);
		
		Brain aNewBrain = new Brain();
//		Human vinay = new Human("vinay",170,new Brain());
		Human vinay = new Human("vinay",170,aNewBrain);
		Human ben = new Human();
		Human steeve = new Human();
		
		System.out.println(ben.getPi());
		System.out.println(steeve.getPi());
		
//		vinay.name = "Vinay"; 
//		vinay.weight = 1700;
//		vinay.setWeight(1700);
//		vinay.getWeight();
//		System.out.println(vinay.getWeight());
		
	}

}
