package com.kash.models;

import java.util.HashSet;
import java.util.Set;

public class Room {
	
//	private int room_id;
//	private static int auto_room_inc = 1;
	
	static Set<Room> rooms = new HashSet<Room>();
	
	private Room left;
	private Room right;
	private Room fwd;
	private Room back;
	private Item i;
	
	private String name;
	
	public Room(String s) {
		this.name = s;
//		this.room_id = auto_room_inc;
//		this.auto_room_inc += 1;
		
		this.left = null;
		this.right = null;
		this.fwd = null;
		this.back = null;
		this.i = null;
		
		rooms.add(this);
	}
	
	public void setRoomItem(Item ii) {
		this.i = ii;
	}
	
	public Room(String s, Item it) {
		this.name = s;
//		this.room_id = auto_room_inc;
//		this.auto_room_inc += 1;
		
		this.left = null;
		this.right = null;
		this.fwd = null;
		this.back = null;
		this.i = it;
		
		rooms.add(this);
	}
	
	public static Room getRoom(String s) {
		for(Room r: rooms) {
			if (r.getName().equals(s)) {
				return r;
			}
		}
		//System.out.println(rooms);
		//System.out.println("bone");
		return null;
	}
	
	public void setRooms(Room l, Room r, Room f, Room b) {
		left = l;
		right = r;
		fwd = f;
		back = b;
	}
	
	public void setRooms(Room l, Room r, Room f, Room b, Item it) {
		left = l;
		right = r;
		fwd = f;
		back = b;
		this.i = it;
	}
	
	public void setItem(Item it) {
		this.i = it;
	}
	
//	public String currentRoom() {
//		return name;
//	}
//	
	public String toString() {
		if (this.i != null) {
			return this.name + " has " + this.i;
		}
		else { 
			return this.name;
		}
	}
	
//	public String getRoomName() {
//		return this.name;
//	}
	/*
	public void setLeft(Room r) {
		left = r;
	}
	public void setRight(Room r) {
		right = r;
	}
	public void setUp(Room r) {
		fwd = r;
	}
	public void setDown(Room r) {
		back = r;
	}
	*/
	public Room getLeft() {
		return left;
	}
	public Room getRight() {
		return right;
	}
	public Room getUp() {
		return fwd;
	}
	public Room getDown() {
		return back;
	}
	
	public String getName() {
		return this.name;
	}
}
