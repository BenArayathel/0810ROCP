package com.example.classes.human.models;

public class Human {
	
	private Brain myBrain;
//	private Organ[] myOrgans;
	private String name ;
	private double weight ;
	public static double pi = 3.14;
	
	//By default, the JVM creates a constructor for us if none exist
	
	public Human() {
		// no args constructor 
		System.out.println("I'm existing now");
		this.myBrain = new Brain();
		this.name = " No name";
		this.weight = 0;
	}
	
	public Human(String name, double weight, Brain myBrain) {
		//all-args constructor
		System.out.println("Inside all-args");
		this.name = name;
		this.weight = weight;
		this.myBrain = myBrain;
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public static void setPi(double newValue) {
		pi = newValue;
	}
	
	public static double getPi() {
		return pi;
	}
	
	
	public void setWeight(double weight) {
		
		if(weight < 0) {
			System.out.println("That's not a valid weight");
		} else if(weight > 1000){
			System.out.println("Being a bit unfair there");
		} else {
			this.weight = weight;
		}
		
	}
	
	

}
