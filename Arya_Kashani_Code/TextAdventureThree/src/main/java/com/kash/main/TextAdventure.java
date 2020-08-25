package com.kash.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.kash.dao.ConnectionFactory;
import com.kash.dao.Dao;
import com.kash.dao.DaoImpl;
import com.kash.models.Item;
import com.kash.models.Player;
import com.kash.models.Room;


public class TextAdventure {
	
	public static void tempname(Room r) {
		// SELECT * FROM rooms WHERE room_name = ' r.getName() '
		try {
			Connection conn = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM rooms WHERE room_name = '" + r.getName() + "'";
			
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			if(rs.next()) {
				String item_name = rs.getString("item_name");
				Item it = Item.getItem(item_name);
				r.setItem(it);
			}
			
			conn.close();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		Dao dao = new DaoImpl();
		
		Item phone = new Item("iPhone");
		Item sandwich = new Item("Sandwich");
		Item crowbar = new Item("Crowbar");
		Item watch = new Item("Watch");
		
		Room one = new Room("Living Room");
		tempname(one);
		Room two = new Room ("Kitchen");
		tempname(two);
		Room three = new Room("Garage");
		tempname(three);
		Room four = new Room("Garden");
		tempname(four);
		Room five = new Room("Play Room");
		tempname(five);
		Room six = new Room("Master Bedroom");
		tempname(six);
		Room seven = new Room("Office");
		tempname(seven);
		Room eight = new Room("Guest Room");
		tempname(eight);
		
		one.setRooms(four, two, three, five);
		two.setRooms(one, seven, eight, six);
		three.setRooms(null, eight, null, one);
		four.setRooms(null, one, null, null);
		five.setRooms(null, six, one, null);
		six.setRooms(five, null, two, null);
		seven.setRooms(two, null, null, null);
		eight.setRooms(three, null, null, two);
		
		// things below here change
		
		Scanner s = new Scanner(System.in);
		
		// find out which room player is in
		Room r = dao.playerInWhichRoom();
		
		//System.out.println(r);
		
		Player p = new Player(r);
		
		//System.out.println(p);
		
		System.out.println("Hello, Welcome to Arya's Text Adventure!");
		//System.out.println("You are in " + r);
		System.out.println("Entry options are: Backpack, Left, Right, Forward, Down, Pickup, Drop *item*, Exit");
		
		while (true) {
			//r = dao.playerInWhichRoom();
			//System.out.println(Room.rooms);
			System.out.println("You are in " + r);
			
			System.out.print("Please enter a command: ");
			String str = s.nextLine();
			//System.out.println(str);
			if(str.equals("exit") || str.equals("Exit")|| str.equals("EXIT")) {
				break;
			}
			else if (str.toLowerCase().equals("backpack")) {
				//dao.whatsInBackpack();
				dao.checkBackpack();
			}
			else if(str.toLowerCase().equals("pickup")) {
				//dao.pickup(p.getCurrState().getName());
				Item i = dao.checkRoom(r);
				if (i != null) {
					dao.addToBackpack(i);
					dao.removeFromRoom(r);
					r.setRoomItem(null);
				}
				else {
					System.out.println("Nothing in room to pick up!");
				}
				
			}
			else if(str.length() > 5 && str.substring(0, 4).toLowerCase().equals("drop")) {
				try {
					String[] ff = str.split(" ");
					String item_name = ff[1];
					Item i = Item.getItem(item_name);
					if(i != null) {
						boolean b = dao.addToRoom(r, i);
						if (b==true) {
							//dao.removeFromBackpack(i);
							
							r.setRoomItem(i);
						}
					}
					else {
						System.out.println("Item not in backpack!");
					}
					
				}
				catch (Exception e) {
					System.out.println("TYPO! must type word 'drop' and then *item*");
				}
			}
			else {
				p.move(str, dao);
				r = p.getCurrState();
			}
			
		}
		
		System.out.println("You exited the house from the " + p.getCurrState());
		s.close();
	}
	
}
