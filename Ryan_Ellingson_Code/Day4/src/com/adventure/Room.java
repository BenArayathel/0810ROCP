package com.adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {
	private String name;
	private Room forward;
	private Room back;
	private Room left;
	private Room right;
	private Boolean isEntry;
	
	public Room(String name) {
		this.name = name;
		this.forward = null;
		this.back = null;
		this.left = null;
		this.right = null;
		this.isEntry = false;
	}
	
	public Room(String name, boolean isEntry) {
		this(name);
		this.isEntry = true;
	}
	
	public Room enterRoom(Scanner sc) {
//		check all the directions
//		for each direction that is not null, list it as an option in syso
//		check user's input, if a valid choice return that room
		System.out.println("You are in the " + this.name);
		ArrayList<String> choices = new ArrayList<String>();
		if (this.forward != null)  {
			System.out.println("In front of you is the " + this.forward.getName());
			choices.add("forward");
		}
		if (this.back != null || this.isEntry) {
			if (this.isEntry) {
				System.out.println("Behind you is the exit");
			} else {
				System.out.println("Behind you is the " + this.back.getName());
			}
			choices.add("back");
		}
		if (this.left != null) {
			System.out.println("To the left is the " + this.left.getName());
			choices.add("left");
		}
		if (this.right != null) {
			System.out.println("To the right is the " + this.right.getName());
			choices.add("right");
		}
		String message = "";
		for (int i=0; i<choices.size(); i++) {
			if (i == choices.size() -1) {
				message += choices.get(i);
			} else {
				message += choices.get(i) + ", ";
			}
		}
		while (true) {
			System.out.println("Enter one of the following: " + message);
			String direction = sc.nextLine();
			if (choices.contains(direction)) {
				switch(direction) {
				case "forward":
					return this.forward;
				case "back":
					return this.back;
				case "left":
					return this.left;
				case "right":
					return this.right;
				}
			}
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public Room getForward() {
		return this.forward;
	}
	
	public void setForward(Room forward) {
		this.forward = forward;
	}
	
	public Room getBack() {
		return this.back;
	}
	
	public void setBack(Room back) {
		this.back = back;
	}
	
	public Room getLeft() {
		return this.left;
	}
	
	public void setLeft(Room left) {
		this.left = left;
	}
	
	public Room getRight() {
		return this.right;
	}
	
	public void setRight(Room right) {
		this.right = right;
	}
}
