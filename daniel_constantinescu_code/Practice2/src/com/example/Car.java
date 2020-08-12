package com.example;

public class Car extends Vehicle{
	private String model;
	
	public static void main(String[] args){
		
		Car myCar=new Car();
		myCar.brand="Ford";
		myCar.model="Mustang";
		myCar.honk();
		
	}
}
