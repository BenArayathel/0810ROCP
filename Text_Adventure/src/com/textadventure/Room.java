package com.textadventure;

import java.util.ArrayList;
import java.util.List;

public class Room {
	
	private String name;
	private String description;
	private Room forward;
	private Room back;
	private Room left;
	private Room right;
	private List<String> options = new ArrayList<>();
	
	public Room(String name) {
		setName(name);
		setForward(null);
		setBack(null);
		setLeft(null);
		setRight(null);
	}
	
	public void currentRoom() {
		System.out.println("You are in the " + this.getName());
		System.out.println("");
		System.out.println(this.getDescription());
		System.out.println("");
		if (this.forward != null) {
			System.out.println("In front of you is the " + this.forward.getName() + ".");
		}
		if (this.back != null) {
			System.out.println("Behind you is the " + this.back.getName() + ".");
		}
		if (this.left != null) {
			System.out.println("To your left is the " + this.left.getName() + ".");
		}
		if (this.right != null) {
			System.out.println("To your right is the " + this.right.getName() + ".");
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
			case "forward":
				return this.getForward();
			case "back":
				return this.getBack();
			case "left":
				return this.getLeft();
			case "right":
				return this.getRight();
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

	public Room getForward() {
		return forward;
	}

	public Room getBack() {
		return back;
	}

	public Room getLeft() {
		return left;
	}

	public Room getRight() {
		return right;
	}
	
	public void setForward(Room forward) {
		if (forward != null) {
			this.forward = forward;
			this.options.add("forward");
		}
	}

	public void setBack(Room back) {
		if (back != null) {
			this.back = back;
			this.options.add("back");
		}
	}
	
	public void setLeft(Room left) {
		if (left != null) {
			this.left = left;
			this.options.add("left");
		}
	}
	
	public void setRight(Room right) {
		if (right != null) {
			this.right = right;
			this.options.add("right");
		}
	}
}
