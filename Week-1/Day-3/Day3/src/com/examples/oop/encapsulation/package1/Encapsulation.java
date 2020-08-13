package com.examples.oop.encapsulation.package1;

import com.examples.oop.encapsulation.package2.DemoObject;
import com.examples.oop.encapsulation.package2.Pojo;

public class Encapsulation {
	
	/*
	 * Is the practice of restricting access to resources within your class or object. This is mainly 
	 * to ensure data isn't accessible without the appropriate permissions.
	 * 
	 * Java implements this via access modifier keywords:
	 * 
	 * 		public: This resources is accessible to any system
	 * 
	 * 		protected: This resources is only available to classes or objects with the same package 
	 * 					as the resource or if it's a child class.
	 * 
	 * 		default (implicit): This resources is only available to classes or objects within the same
	 * 					package
	 * 
	 * 		private: Only available to the class, no other systems. 
	 */
	
	public static void main(String[] args) {
		
//		DemoObject dObject = new DemoObject();
//		System.out.println(dObject.secret);
		
		Pojo p = new Pojo("Here's my secret", null);
		p.setSecret("It's now in the open");
		System.out.println(p);		
		
		DemoObject dObject = new DemoObject();
		ChildClass cs = new ChildClass();
		
//		String s = cs.secret;
		cs.myMethod();
		
		
		/*
		 * 
		 * 3 Broad packages
		 * 
		 * 1 package: presentation layer com.example.oop == com/example/oop/
		 * 2 package: service layer 
		 * 3 package: database layer
		 * 
		 */
		
	}

}
