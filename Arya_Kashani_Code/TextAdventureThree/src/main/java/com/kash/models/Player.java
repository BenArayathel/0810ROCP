package com.kash.models;

import java.util.ArrayList;
import java.util.List;

import com.kash.dao.Dao;

public class Player {
	
	private Room currentState;
	private List<Item> backpack;
	
	public Player() {
		currentState = null;
		backpack = new ArrayList<Item>();
	}
	
	public Player(Room r) {
		currentState = r;
		backpack = new ArrayList<Item>();
	}
	
	public void addItem(Item i) {
		backpack.add(i);
	}
	
	public void dropItem(Item i) {
		if (backpack.contains(i)) {
			int index = backpack.indexOf(i);
			backpack.remove(index);
		}
	}
	
	
	public void setCurrState(Room r) {
		currentState = r;
	}
	public Room getCurrState() {
		return currentState;
	}
	
	public void move(String input, Dao dao) {
		if (input.equals("L") || input.equals("l") || input.equals("Left") || input.equals("LEFT") || input.equals("left")) {
			if(currentState.getLeft() == null) {
				System.out.println("Can't go left");
			}
			else {
				dao.playerLeftRoom(currentState);
				
				Room r = currentState.getLeft();
				currentState = r;
				System.out.println("You are now in " + currentState);
				
				dao.playerEnteredRoom(currentState);
			}
		}
		else if(input.equals("R") || input.equals("r")|| input.equals("Right") || input.equals("RIGHT")|| input.equals("right")) {
			if(currentState.getRight() == null) {
				System.out.println("Can't go right");
			}
			else {
				dao.playerLeftRoom(currentState);
				
				Room r = currentState.getRight();
				currentState = r;
				System.out.println("You are now in " + currentState);
				
				dao.playerEnteredRoom(currentState);
			}
		}
		else if (input.equals("F") || input.equals("f") || input.equals("Forward") || input.equals("FORWARD")|| input.equals("forward")) {
			if(currentState.getUp() == null) {
				System.out.println("Can't go forward");
			}
			else {
				dao.playerLeftRoom(currentState);
				
				Room r = currentState.getUp();
				currentState = r;
				System.out.println("You are now in " + currentState);
				
				dao.playerEnteredRoom(currentState);
			}
		}
		else if (input.equals("D") || input.equals("d") || input.equals("Down") || input.equals("DOWN") || input.equals("down")) {
			if(currentState.getDown() == null) {
				System.out.println("Can't go back");
			}
			else {
				dao.playerLeftRoom(currentState);
				
				Room r = currentState.getDown();
				currentState = r;
				System.out.println("You are now in " + currentState);
				
				dao.playerEnteredRoom(currentState);
			}
		}
		else {
			System.out.println("Invalid input; try again.");
		}
	}
	
	@Override
	public String toString() {
		return "player in " + this.currentState + " and has " + this.backpack;
	}
}
