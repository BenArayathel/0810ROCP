package com.examle.inheritance.model;

public class Animal {
	
	public boolean hungry;
	public String name;
	
	public Animal() {
		//super();
	}
	
	public Animal(boolean hungry, String name) {
		//super();
		this.hungry = hungry;
		this.name = name;
	}
	
	public void makeSound() {
		System.out.println("I'm making a sound");
	}
	
	@Override
	public String toString() {
		return "This is the Animal class";
		
	}

}
