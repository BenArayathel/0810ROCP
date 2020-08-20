package com.example.models;

public class TeaCup {
	
	private boolean isFull() {
		return true;
	}
	
	public String getName() {
		return "Apple";
	}
	
	public boolean storeTea() {
		System.out.println("I've got tea in me");
		return isFull();
	}

}
