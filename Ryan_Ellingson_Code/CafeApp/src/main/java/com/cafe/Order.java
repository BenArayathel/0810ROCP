package com.cafe;

import java.util.HashMap;

public class Order {
	private String name;
	private HashMap<String, Integer> items;
	
	public Order(String name) {
		this.name = name;
		this.items = new HashMap<>();
	}
	
	public void addItem(String itemName) {
		if (items.containsKey(itemName)) {
			this.items.put(itemName, this.items.get(itemName) + 1);
		} else {
			this.items.put(itemName, 1);
		}
	}
	
	public double getTotal(Menu menu) {
		double result = 0.0;
		for (String itemName : this.items.keySet()) {
			double price = menu.getMenu().get(itemName);
			result += price * this.items.get(itemName);
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "Name: " + this.name;
		for (String itemName : this.items.keySet()) {
			result += "\n"+ itemName + " x " + this.items.get(itemName);
		}
		return result;
	}
	
	public void clearOrder() {
		this.items.clear();
	}
}
