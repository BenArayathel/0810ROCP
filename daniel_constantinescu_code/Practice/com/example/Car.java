package com.example;

class Vehicle{
	protected String brand;
	public void honk() {
		System.out.println("TUU")
	};
}

public class Car extends Vehicle{
	private String model;
	
	public static void main(String[] args){
		Car myCar=new Car();
		myCar.brand="Ford";
		myCar.model="Mustang"
		myCar.honk();
		
	}
}