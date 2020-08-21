package com.cafe.models;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private int orderID;
	private Map<FoodItem, Integer> orderContents = new HashMap<FoodItem, Integer>();

	public Order(int orderID, Map<FoodItem, Integer> orderContents) {
		super();
		this.orderID = orderID;
		this.orderContents = orderContents;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Map<FoodItem, Integer> getOrderContents() {
		return orderContents;
	}

	public void setOrderContents(Map<FoodItem, Integer> orderContents) {
		this.orderContents = orderContents;
	}
}
