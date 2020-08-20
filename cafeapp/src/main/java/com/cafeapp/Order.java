package com.cafeapp;

import java.util.HashMap;
import java.util.Scanner;

import com.cafeapp.models.Item;

public class Order {
	//Logic for requesting items to add to OrderList, adding names
	private String name;
	private HashMap<Item, Integer> orderItems = new HashMap<>();
	
	public Order() {
		//
	}
	
	public void makeOrder(Scanner sc, String category, String input) {
		Item current = Menu.getItem(category, input);
		HashMap<String, String> request = new HashMap<>();
		request.put("amount", "Amount");
		HashMap<String, Integer> amount = Main.console(sc, request, 1);

		int i = amount.get("amount");
		if (i != 0) {
			orderItems.put(current, i);
		}
	}
	
	public HashMap<Item, Integer> getOrder() {
		return orderItems;
	}
	
	public void clearOrder() {
		this.orderItems = new HashMap<>();
	}
	
	public void setName(Scanner sc) {
		HashMap<String, String> request = new HashMap<>();
		request.put("fname", "First Name");
		request.put("lname", "Last Name");
		HashMap<String, String> name = Main.console(sc, request);
	}
}
