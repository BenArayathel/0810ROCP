package com.cafeapp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.cafeapp.dao.CafeDAOImpl;
import com.cafeapp.models.*;

public class Menu {
	/*
	 * Generate all Menu items for parsing
	 */
	private static HashMap<String, HashMap<String,Item>> menu = new HashMap<String, HashMap<String,Item>>();
//	private static String[] categories = {"appetizers",
//										  "beverages",
//										  "lunch"};
	public static void generate() {
		
		CafeDAOImpl cDAO = new CafeDAOImpl();
		List<String> categories = cDAO.selectCategories();
		
		for (String category:categories) {
			List<Item> items = cDAO.selectMenuItemsByCategory(category);
			HashMap<String,Item> currentItems = new HashMap<String, Item>();
			for (Item itemToBeAdded: items) {
				currentItems.put(itemToBeAdded.getName(), itemToBeAdded);
			}
			menu.put(category, currentItems);
		}
		
//		//List of Beverages
//		HashMap<String,Item> beverage = new HashMap<>();
//			beverage.put("Coca Cola", new Beverage("Coca Cola", 2.00));
//			beverage.put("Sweet Tea", new Beverage("Sweet Tea", 3.00));
//			beverage.put("Unsweet Tea", new Beverage("Unsweet Tea", 3.00));
//			beverage.put("Orange Juice", new Beverage("Orange Juice", 3.00));
//		menu.put("beverage", beverage);
//		HashMap<String,Item> dessert = new HashMap<>();
//			dessert.put("Chocolate Ice Cream", new Dessert("Chocolate Ice Cream", 5.00));
//			dessert.put("Vanilla Ice Cream", new Dessert("Vanilla Ice Cream", 5.00));
//			dessert.put("Cookie", new Dessert("Cookie", 3.00));
//		menu.put("dessert", dessert);
		
//		for (String category:categories) {
//			menu.put(category, new Item(category));
//			
//		}
		
	}
	
	public static Item getItem(String category, String item) {
		HashMap<String, Item> categoryItems = menu.get(category);	//Let's keep it local, less database calling
		Item order = categoryItems.get(item);
		return order;
		
	}
	
	public static String[] mainMenu() {
		return (String[]) menu.keySet().toArray(new String[0]);
	}
	
	public static String[] menuCategory(String category) {
		Item[] menuItems = (Item[]) menu.get(category).values().toArray(new Item[0]);
		HashSet<String> menu = new HashSet<>();
		for (Item item:menuItems) {
			menu.add(item.getName());
		}
		return (String[]) menu.toArray(new String[0]);
	}
}
