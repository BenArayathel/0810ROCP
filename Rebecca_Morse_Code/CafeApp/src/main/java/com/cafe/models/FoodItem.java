package com.cafe.models;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FoodItem {
	private int id;
	private String name;
	private String type;
	private String description;
	private float cost;

	public FoodItem(String name, String type, String description, float f) {
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = f;
	}


	public FoodItem(int id, String name, String type, String description, float f) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.description = description;
		this.cost = f;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "FoodItem [id=" + id + ", name=" + name + ", type=" + type + ", description=" + description + ", cost="
				+ cost + "]";
	}

}
