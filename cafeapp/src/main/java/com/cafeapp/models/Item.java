package com.cafeapp.models;

public class Item{
	/*
	 * Create an Item inside an order
	 * 
	 */
	private String category = "";
	private String name = "";
	private double cost;
	
	public Item(String name, double cost) {
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
	
}
