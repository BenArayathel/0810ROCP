package com.cafe.models;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private int orderID;
	private Customer customer;
	
	private Map<FoodItem, Integer> orderContents = new HashMap<FoodItem, Integer>();

	public Order(int orderID, Map<FoodItem, Integer> orderContents, String customerName) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

	
}
