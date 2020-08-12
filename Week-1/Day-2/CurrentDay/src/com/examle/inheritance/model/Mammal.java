package com.examle.inheritance.model;

public class Mammal extends Animal{
	
	protected boolean warmBlooded;
	public int numberOfLegs;
	
	public Mammal() {
		//super();
//		super("String");
		
	}
	
	public Mammal(boolean warmBlooded, int numberOfLegs) {
		//super();
		this.warmBlooded = warmBlooded;
		this.numberOfLegs = numberOfLegs;
	}
	
	public Mammal(boolean hungry, String name, boolean warmBlooded, int numberOfLegs) {
//		super();
		super(true,"mammly");
		
		this.warmBlooded = warmBlooded;
		this.numberOfLegs = numberOfLegs;
		
	}
	
	@Override
	public void makeSound() {
		System.out.println("Making mammal sounds now.");
	}
	
	public void doMammalStuff() {
		super.makeSound();
		System.out.println("doing mammal stuff");
	}

}
