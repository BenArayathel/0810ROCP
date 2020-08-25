package com.cafe;

import java.util.HashMap;

public class Menu {
	private HashMap<String, Double> menu;
	
	public Menu() {
		super();
		this.menu = new HashMap<>();
		
		this.menu.put("burger", 4.00);
		this.menu.put("fries", 1.50);
		this.menu.put("soda", 1.00);
	}
	
	public HashMap<String, Double> getMenu() {
		return this.menu;
	}
	
	@Override
	public String toString() {
		String result = "Menu: \n";
		for (String itemName : this.menu.keySet()) {
			result += itemName + ": $" + this.menu.get(itemName) + "\n";
		}
		return result;
	}
}
