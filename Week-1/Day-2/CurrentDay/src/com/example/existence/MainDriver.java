package com.example.existence;
import com.example.model.DemoObject;

public class MainDriver {
	
	//When we define
	
	
	public void myMethod() {
		DemoObject a;
	}
	
	public static void main(String[] args) {
		
		
		
		int a; //	DECLARING a variable, of type int of name "a"
		a = 7; //	INIATILIZATION is assigning value to a variable 
		new Object(); // 	INSTANTIATION, this is creating an instance of a class (a object)
		
		int b = 12; //Declaring and initializing 
		Object c = new Object(); // Instantiation, declaration and initializing
		
		int d = 2;
		int e = d;
		
		d = 5;
		
//		System.out.println(d);
//		System.out.println(e);
		
//		DemoObject myObject = new DemoObject(2,"a string");
//		DemoObject sameObject = myObject;
//		DemoObject someMoreObject = myObject;
		
		
//		myObject.a = 7;
//		
//		System.out.println(sameObject.a); //pass-by reference 
		
		/*
		 * PASS BY REFERENCE vs PASS BY VALUE
		 * 
		 * 	PASS BY REFERENCE will pass all the memory address. Objects are pass by reference.
		 * 
		 * 	MyObject ob1 = new MyObject();
		 * 	MyObject ob2 = ob1;
		 * 
		 * 	modifications to ob1 or to ob1 will affect the other variable, they both point to the same object in memory 
		 * 
		 * PASS BY VALUE will pass the value. Primitive values are pass by value.
		 * 
		 * int a = 7;
		 * int b = a;
		 * 
		 * a = 1;
		 * 
		 * syso(a); //will print 1
		 * syso(b); //will print 7
		 * 
		 * 
		 */
		
		/*
		 * STACK vs HEAP 
		 * 
		 * Stack?
		 * 		Speed: faster than the heap 
		 * 		Store? primitives and reference variables and methods
		 * 
		 * Heap?
		 * 		Store? Objects and pretty much everything else
		 * 
		 */
		
		/*
		 * MEMORY MANAGEMENT
		 * 
		 * 
		 */
		
		
		
		
	}

}
