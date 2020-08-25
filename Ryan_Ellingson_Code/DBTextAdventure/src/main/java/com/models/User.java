package com.models;

public class User {
	private int id;
	private String name;
	private int currentRoom;
	
	public User() {
		super();
	}

	public User(int id, String name, int currentRoom) {
		super();
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

	public int getCurrentRoom() {
		return currentRoom;
	}

	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", currentRoom=" + currentRoom + "]";
	}
}
