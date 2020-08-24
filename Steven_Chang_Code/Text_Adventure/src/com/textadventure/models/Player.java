package com.textadventure.models;

import java.util.List;

public class Player {
	private int id;
	private String name;
	private Room currentRoom;
	private List<Item> inventory;
	private List<Room> rooms;
	
	public Player(int id, String name, Room currentRoom, List<Item> inventory) {
		this.id = id;
		this.name = name;
		this.currentRoom = currentRoom;
		this.inventory = inventory;
	}
	
	public Player(int id, String name, Room currentRoom) {
		this.id = id;
		this.name = name;
		this.currentRoom = currentRoom;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Room getCurrentRoom() {
		return currentRoom;
	}
	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}
	public List<Item> getInventory() {
		return inventory;
	}
	public void setInventory(List<Item> inventory) {
		this.inventory = inventory;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
}
