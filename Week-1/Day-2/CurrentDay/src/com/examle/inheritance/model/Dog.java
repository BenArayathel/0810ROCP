package com.examle.inheritance.model;

public class Dog extends Mammal{
	
	public Dog() {
		//super();
	}
	
	public Dog(boolean hungry, String name,boolean warmBlooded, int numberOfLegs) {
		//super();
//		super(warmBlooded,numberOfLegs);
//		
	}
	
	public void chase() {
		super.makeSound();
		super.doMammalStuff();
		System.out.println("chasing the ball");
	}

	

}
