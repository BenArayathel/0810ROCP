package com.textadventure;

import java.util.List;
import java.util.Scanner;

import com.textadventure.dao.TextAdventureDAO;
import com.textadventure.models.Player;
import com.textadventure.models.Room;

public class MainDriver {
	
//	public static void setup() {
//		
//	}

	public static void main(String[] args) {
		//setup
		TextAdventureDAO taDAO = new TextAdventureDAO();
//		List<Room> rooms = taDAO.selectAllRooms();
		Scanner sc = new Scanner(System.in);
		System.out.println("name?");
		String name = sc.nextLine();
		if (taDAO.selectPlayerByName(name) == null) {
			System.out.println("Player not found. Creating new player.");
			taDAO.insertPlayer(name);
		}
		Player currentPlayer = taDAO.selectPlayerByName(name);
		
		boolean run = true;
		while(run) {
			System.out.println(currentPlayer.getCurrentRoom().getName());
			Room currentRoom = currentPlayer.getCurrentRoom();
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
