package com.textadventure;

import java.util.List;
import java.util.Scanner;

public class MainDriver {
	
//	public static void setup() {
//		
//	}

	public static void main(String[] args) {
		//setup
		Room entryway = new Entryway();
		Room livingroom = new LivingRoom();
		Room kitchen = new Kitchen();
		Room basement = new Basement();
		Room backyard = new Backyard();
		
		entryway.setForward(livingroom);
		livingroom.setForward(backyard);
		livingroom.setLeft(basement);
		livingroom.setRight(kitchen);
		livingroom.setBack(entryway);
		backyard.setBack(livingroom);
		kitchen.setBack(livingroom);
		basement.setBack(livingroom);
		
		Room currentRoom = entryway;
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while(run) {
			currentRoom.currentRoom();
			String command = getCommand(sc, currentRoom);		//Get Input
			
			if (currentRoom.direction(command) != null) {		//Dedicated Directional Commands
				currentRoom = currentRoom.direction(command);
			} else {
				currentRoom = currentRoom.doSpecialOption();
			}
			if (currentRoom == null) {
				run = false;
			}
			System.out.println("============================================");
		}
		
	}
	
	// Get Input & Look for valid commands
	
	public static String getCommand(Scanner sc, Room currentRoom) {
		List<String> options = currentRoom.getOptions();
		boolean valid = false;
		String input = "";
		while (!(valid)) {
			printOptions(currentRoom);
			input = sc.nextLine();
			input = input.toLowerCase();
			if (options.contains(input)) {
				valid = true;
			} else {
				System.out.println("Invalid Command");
			}
		}
		return input;
	}
	
	// Get Valid Options
	
	public static void printOptions(Room currentRoom) {
		System.out.println("");
		System.out.println("Available Commands:");
		for (String command:currentRoom.getOptions()) {
			System.out.print(" " + command);
		}
		System.out.println("");
		System.out.print("> ");
	}
	
}
