package com.adventure;

import java.util.Scanner;

public class TextAdventure {

//	entryway
//	living room
//	kitchen
//	basement
	
//	entryway - forward to living room
//	living room - right to kitchen, back to entryway, left to basement
//	basement - back to living room
//	kitchen - back to living room
	
	public static void main(String[] args) {
		Room entryway = new Room("Entryway", true);
		Room livingRoom = new Room("Living Room");
		Room kitchen = new Room("Kitchen");
		Room basement = new Room("Basement");
		
		Scanner sc = new Scanner(System.in);
		
//		connect the entryway
		entryway.setForward(livingRoom);
		
//		connect the living room
		livingRoom.setRight(kitchen);
		livingRoom.setLeft(basement);
		livingRoom.setBack(entryway);
		
//		connect the basement
		basement.setBack(livingRoom);
		
//		connect the kitchen
		kitchen.setBack(livingRoom);
		
		Room currentRoom = entryway;
		while (currentRoom != null) {
			currentRoom = currentRoom.enterRoom(sc);
		}
		System.out.println("Thanks for visiting!");
		
		sc.close();
	}

}
