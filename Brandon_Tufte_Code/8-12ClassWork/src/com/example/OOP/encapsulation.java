package com.example.OOP;

public class encapsulation {

	/*
	 * Practice of restricting access to resources within class or object. makes data inaccessible
	 * without the correct permissions
	 * 
	 * implemented via modifier keywords:
	 *	public - accessible to any system
	 *	protected - accessible to child class or class in same package
	 *	default(implicit) - accessible to class of same package
	 *	private -  accessible to only the class defined
	 *
	 */
	
	public static void main(String[] args) {
		int a = 4;
		System.out.println(a++);
	}
}
