package com.cafe.models;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	private Map<Integer, FoodItem> menu = new HashMap<Integer, FoodItem>();

	public Menu(Map<Integer, FoodItem> menu) {
		this.menu = menu;
	}

	public Map<Integer, FoodItem> getMenu() {
		return menu;
	}

	public void setMenu(Map<Integer, FoodItem> menu) {
		this.menu = menu;
	}

}
