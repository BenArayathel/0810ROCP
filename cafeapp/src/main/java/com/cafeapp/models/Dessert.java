package com.cafeapp.models;

public class Dessert extends Item{

	public Dessert(String name, double cost) {
		super(name, cost);
		super.setCategory("Dessert");
	}
	
}
