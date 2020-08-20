package com.revature;

import java.util.Scanner;

public class Driver {
	
	public static void myMethod(Scanner sc) {
		
		greetings();
		
		String name = sc.nextLine();
		
		if(name.equals("Ben")) {
			System.out.println("Welcome to secret greeting");
		}else {
			System.out.println("Welcome " + sc.nextLine());
		}
		
		System.out.println("Welcome " + sc.nextLine());
		
	}

	public static void betterMethod(Scanner sc) {
		greetings();
	}
	
	private static void greetings() {

		System.out.println("Welcome to my console");
		System.out.println(" This is my console world");
		System.out.println("Please input your name");
		
		
	}

	public static void main(String[] args) {


		
		Scanner sc = new Scanner(System.in);
		
		myMethod(sc);
		
		sc.close();

	}

}
