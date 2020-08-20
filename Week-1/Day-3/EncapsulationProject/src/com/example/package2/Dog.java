package com.example.package2;

import com.example.package1.Animal;
//import com.example.package1.Vegetation;

public class Dog extends Animal{
	
	
	public void myMethod() {
		
		System.out.println(this.id); //id is accessible because its public
		System.out.println(this.name); //name is accessible because it is "protected", different package but we are a child class
//		System.out.println(this.age); //age is NOT accessible because it is default, different package and child classes do get access to default values
//		System.out.println(this.weight);//weight is ONLY accessible to the Animal class
		
//		Vegetation v = new Vegetation();
	}
}
