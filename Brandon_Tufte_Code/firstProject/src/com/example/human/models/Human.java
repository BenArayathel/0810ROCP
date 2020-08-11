package com.example.human.models;

public class Human {
	
	private Brain myBrain;
	public String name;
	private Organ myOrgans;
	private double weight;
	//Static is immediately stored in memory
	
	//No argument constructor
	public Human() {
		System.out.println("I'm existing now.");
		this.myBrain = new Brain();
		this.name = "No Name";
		this.weight = 0;
	}
	
	//All arguments constructor
	public Human(String name, double weight, Brain theBrain) {
		System.out.println("I'm existing now.");
		this.myBrain = theBrain;
		this.name = name;
		this.weight = weight;
	}
	
	public double getWeight() {
		return this.weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
}
