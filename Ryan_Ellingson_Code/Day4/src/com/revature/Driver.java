package com.revature;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		myMethod(sc);
		sc.close();
		
	}
	
	public static void myMethod(Scanner sc) {
		greeting();
		String name = sc.nextLine();
		System.out.println("Welcome " + name);
	}

	private static void greeting() {
		System.out.println("Enter your name");
	}
}
