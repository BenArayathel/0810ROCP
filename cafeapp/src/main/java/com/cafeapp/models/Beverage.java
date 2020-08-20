package com.cafeapp.models;

public class Beverage extends Item {

	public Beverage(String name, double cost) {
		super(name, cost);
		super.setCategory("Beverages");
	}
}
