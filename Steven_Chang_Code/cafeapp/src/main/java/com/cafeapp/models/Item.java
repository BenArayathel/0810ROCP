package com.cafeapp.models;

public class Item{
	/*
	 * Create an Item inside an order
	 * 
	 */
	private int itemID;
	private String category = "";
	private String name = "";
	private double cost;
	
	public Item(int id, String category, String name, double cost) {
		setItemID(id);
		setCategory(category);
		setName(name);
		setCost(cost);
	};
	
	@Override
	public String toString() {
		return name + "................. $" + cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
}
