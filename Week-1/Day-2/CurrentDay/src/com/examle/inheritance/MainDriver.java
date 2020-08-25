package com.examle.inheritance;

import com.examle.inheritance.model.Animal;
import com.examle.inheritance.model.Dog;
import com.examle.inheritance.model.Mammal;
import com.examle.inheritance.model.Tree;

public class MainDriver {
	
	public static void main(String[] args) {
		
		Animal a = new Animal();
		Mammal m = new Mammal();
		Dog d = new Dog(true, "doggy",false,4);
		
		/*
		 * INHERITANCE
		 * 	One of the most important aspects of OOP, allows you to inherit methods and variables from parent classes, promoting code reuse
		 * 
		 * Following example we follow 
		 * 	Object (Implicit)-> Animal -> Mammal -> Dog
		 * 
		 * 	Dog inherits all the properties and methods from Mammal, Animal and Object
		 * 	Mammal inherits all the properties from Animal and Object
		 * 	Animal inherits all the properties from Object
		 * 
		 * With Java we can only have linear inheritance, multi-class inheritance (like the following is NOT ALLOWED)
		 * 
		 * 	Tree	-->
		 * 				Mammal --> Dog  "NOT ALLOWED"
		 * 	Animal	-->
		 *  
		 *  
		 *  NOTE: Parent classes do not have access to their child class' methods or variables 
		 *  
		 */
		
//		System.out.println(d.warmBlooded);		
//		System.out.println(d.hungry);
//		System.out.println(d.name);
		
		//animal
//		a.makeSound();
//		a.doMammalStuff();
//		a.chase();
		
		//mammal
//		m.makeSound();
//		m.doMammalStuff();
//		m.chase();
		
		//dog
//		d.makeSound();
//		d.doMammalStuff();
//		d.chase();
		
		
		/*
		 * 
		 * A parent type class can use a child class's constructor, the following code is a valid way to instantiate an object              :
		 * (The inheritance pattern is Animal -> Mammal -> Dog)
		 * 
		 * Animal a = new Animal();
		 * Animal a = new Mammal();
		 * Animal a = new Dog();
		 * 
		 * Mammal m = new Mammal();
		 * Mammal m = new Dog();
		 * 
		 * Dog d = new Dog();
		 * 
		 * 
		 * When you use a child class constructor, you still will not have access to the child method. 
		 * It has to be cast down to the child class to have access. 
		 * 
		 * NOTE: if a child class overrides a parent method, using the child class constructor will give the class the overridden method. 
		 * 
		 */
		
		
		Animal dog = new Mammal();
		dog = (Dog) dog;
		dog.makeSound();
		((Mammal) dog).doMammalStuff();
		((Dog) dog).chase();
		
		
		//The following code will throw an exception during runtime. Even though it is not showing an error at the moment
		
		Dog anotherDog = (Dog) new Animal();
		anotherDog.chase();
		anotherDog.doMammalStuff();
		anotherDog.makeSound();
		
		Animal newAnimal = new Animal();
		Mammal newMammal = new Mammal();
	}
	
	
	/*
	 * Every class in Java is derived from the Object class. If a class does not 
	 * extend any other class, it is directly a child class otherwise it is indirectly
	 * a child class. 
	 * 
	 * toString(): prvides a string representation of an object. 
	 * 
	 * hashCode(): generates a unique number which is hash code. 
	 * 
	 * equals(Object obj): Compares the original object to "obj"
	 * 
	 * getClass() : Returns the class of "this" object
	 * 
	 * finalize(): Run immediately before the garbage collection to delete it from 
	 * 				the heap.
	 * 
	 */
	
	
	
	

}
