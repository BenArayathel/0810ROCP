package com.examle.inheritance.model;

public class Dog extends Mammal{
	
	/*
	 * Lots of lines of code
	 * 
	 */
	
	public Dog() {
		//super();
	}
	
	public Dog(boolean hungry, String name,boolean warmBlooded, int numberOfLegs) {
		//super();
//		super(warmBlooded,numberOfLegs
//		
	}
	
	public void chase() {
		super.makeSound();
		super.doMammalStuff();
		super.getClass();
		System.out.println("chasing the ball");
	}
	
//	public void makeSound() {
//		System.out.println("BArking");
//	}

	

}
