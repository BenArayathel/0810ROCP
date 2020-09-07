package com.revature.model;

public class Item {
	
	private int item_id;
	private String name;
	private String category;
	private double price;
	
	
	public Item(int item_id, String name, String category, double price) {
		this.item_id = item_id;
		this.name = name;
		this.category = category;
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return this.item_id + " "
				+ "$" + this.price + " "
				+ this.category + "     "
				+ this.name;
	}
	
	

}



