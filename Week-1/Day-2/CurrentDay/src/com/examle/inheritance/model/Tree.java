package com.examle.inheritance.model;

public class Tree {
	
	//The JVM provides us a no-args, default constructor
	// ONLY IF THERE IS NO OTHER CONSTRUCTOR
	
	public Tree(String randomVariable) {
		
	}
	
	public Tree() {
		//super();
	}
	
	public void makeSound() {
		System.out.println("Bristling in the wind");
	}

}
