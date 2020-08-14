package com.revature.tour;

import java.util.Scanner;

public class house {

	public static String initialGreeting = "Welcome to my house! Would you like to go to the kitchen(K), Living room(L) or Bedroom(B)? Enter Letter and hit Enter. ";
	
	public static void main(String[] args) {

		String userResponse;
		Scanner sc;
		
		printGreeting(initialGreeting);
		sc = new Scanner(System.in);
		System.out.println("Where do you want to go");
		userResponse = sc.nextLine();
		
		if (userResponse == "K") {
			printGreeting("You are in the kitchen!");
		}
		
		
		/*
		 * 
		 * House layout: Open Front door: Front: Hallway: Goes to kitchen Right: Living
		 * Room Left: Bedroom.
		 * 
		 * Kitchen: items: Island kitchen Table Cabinets Pantry Sink Appliances go back
		 * go through back door -> yard (outhouse)
		 * 
		 * 
		 * right /living room: Sofa lamp TV go back
		 *
		 *
		 * Bedroom: Bed Dresser Closet lamp
		 * 
		 * need greetings "Welcome to my House"
		 * 
		 * Array[]
		 * 
		 */
		sc.close();
	}

	public static void printGreeting(String str) {
		System.out.println(str);
	}
	
}
