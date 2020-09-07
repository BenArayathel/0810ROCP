package com.revature.model;

import java.util.ArrayList;

public class Order {
	
	private String customerName;
	private ArrayList<Item> items = new ArrayList<Item>();
	private double orderTotal;
	private ArrayList<Integer> itemQuantities = new ArrayList<Integer>();
	
	public String getCustomerName() {
		return this.customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Order() {
		
	}


	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	public ArrayList<Integer> getQuantities(){
		return itemQuantities;
	}
	
	public void addItem(Item item, int quantity) {
		items.add(item);
		itemQuantities.add(quantity);
	}
	
	public void removeItem(int itemNo) {
		items.remove(itemNo);
		itemQuantities.remove(itemNo);
	}
	
	public void calcOrderTotal() {
		this.orderTotal = 0;
		for(int i=0; i<items.size(); i++) {
			this.orderTotal += items.get(i).getPrice() * itemQuantities.get(i);
		}
	}

	public double getOrderTotal() {
		return this.orderTotal;
	}
	
	public int getNumberOfItems() {
		return this.items.size();
	}

	
	@Override
	public String toString() {
		String order = "Order:\n";
		for(int i=0; i<items.size(); i++) {
			order += items.get(i).getName() + " x " + itemQuantities.get(i) + "\n";
		}
		return order;
	}
}
