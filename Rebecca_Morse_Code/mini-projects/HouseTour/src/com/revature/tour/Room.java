package com.revature.tour;

public abstract class Room {
	String name;
	String greeting;
	String description;
	String[] items;
	String[] nextRooms;
	
	public String[] inspectRoom() {
		return items;
	}
	
	public void navigate() {
		
	}
	
}
