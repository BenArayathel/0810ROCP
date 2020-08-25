package com.examle.inheritance.model;

public class Cat extends Animal{//IS-A relationship
	
	public Cat(boolean hungry, String name) {
		this.hungry = hungry;
		this.name = name;
	}
	
	public void scratchTree() {
		Tree tree = new Tree();
		tree.makeSound(); //has-a relationship 
	}
}
