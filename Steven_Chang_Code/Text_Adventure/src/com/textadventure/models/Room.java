package com.textadventure.models;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private int id;
	private String name;
	private String description;
	private Room north;
	private Room south;
	private Room east;
	private Room west;
	private List<String> options = new ArrayList<>();
	
	public Room(int id, String name, String description) {
		setId(id);
		setName(name);
		setDescription(description);
		setnorth(null);
		setsouth(null);
		setwest(null);
		seteast(null);
	}
	
	public void currentRoom() {
		System.out.println("You are in the " + this.getName());
		System.out.println("");
		System.out.println(this.getDescription());
		System.out.println("");
		if (this.north != null) {
			System.out.println("To the north of you is the " + this.north.getName() + ".");
		}
		if (this.south != null) {
			System.out.println("To the south you is the " + this.south.getName() + ".");
		}
		if (this.west != null) {
			System.out.println("To your west is the " + this.west.getName() + ".");
		}
		if (this.east != null) {
			System.out.println("To your east is the " + this.east.getName() + ".");
		}
	};
	
	public List<String> getOptions() {
		return this.options;
	}
	
	public void addOption(String newOption) {
		this.options.add(newOption);
	}
	
	public Room direction(String command) {
		switch (command) {
			case "north":
				return this.getnorth();
			case "south":
				return this.getsouth();
			case "west":
				return this.getwest();
			case "east":
				return this.geteast();
			default:
				return null;		//Only if not a directional command
									//No worries for false direction as command is already validated
		}
	}
	
	public void setSpecialOption() {
		
	};
	
	public Room doSpecialOption() {
		return null;
	};
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Room getnorth() {
		return north;
	}

	public Room getsouth() {
		return south;
	}

	public Room getwest() {
		return west;
	}

	public Room geteast() {
		return east;
	}
	
	public void setnorth(Room north) {
		if (north != null) {
			this.north = north;
			this.options.add("north");
		}
	}

	public void setsouth(Room south) {
		if (south != null) {
			this.south = south;
			this.options.add("south");
		}
	}
	
	public void setwest(Room west) {
		if (west != null) {
			this.west = west;
			this.options.add("west");
		}
	}
	
	public void seteast(Room east) {
		if (east != null) {
			this.east = east;
			this.options.add("east");
		}
	}

	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
