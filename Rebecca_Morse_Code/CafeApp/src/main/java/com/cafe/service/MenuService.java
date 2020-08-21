package com.cafe.service;

import java.util.HashMap;
import java.util.Map;

import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.util.Communication;

public class MenuService {
	
	public static final String MENU_TITLE = "The Cat Cafe Menu:\n";
	public static final String SELECT_PROMPT = "\nTo select an Item, enter the number in parentheses.";

	public static Menu makeMenu() {

		Map<Integer, FoodItem> menuContents = new HashMap<Integer, FoodItem>();

		FoodItem water = new FoodItem("Water", "Beverage", "Liquid Refreshment at its' finest!", 0);
		FoodItem lemonade = new FoodItem("Lemonade", "Beverage", "The tastiest Summertime Drink", 2);
		FoodItem veggieBurger = new FoodItem("Veggie Burger", "Entree",
				"Our House-made Veggie Burgers, served with hand-cut fries.", 10);
		FoodItem pasta = new FoodItem("Pasta Supreme", "Entree", "House made pasta with the freshest Pesto around.", 7);
		FoodItem asparagus = new FoodItem("Asparagus Spear", "Side", "Only the freshest!", 17);
		FoodItem cococadoShake = new FoodItem("Cococado Vegan Milkshake", "Dessert",
				"Made with rice dream ice cream, bananas, coconut and avocado.", 4);
		FoodItem pie = new FoodItem("Pie", "Dessert", "Fresh seasonal pie.  Current variety: peach", 5);

		menuContents.put(1, water);
		menuContents.put(2, lemonade);
		menuContents.put(3, veggieBurger);
		menuContents.put(4, pasta);
		menuContents.put(5, asparagus);
		menuContents.put(6, cococadoShake);
		menuContents.put(7, pie);

		Menu menu = new Menu(menuContents);

		return menu;
	}
	
	public static void displayMenu(Menu menu) {
		Communication.communicate(MENU_TITLE);

		for (Map.Entry<Integer, FoodItem> entry : menu.getMenu().entrySet()) {
			System.out.println("(" + entry.getKey() + ") " + entry.getValue().getName() + " - "
					+ entry.getValue().getDescription() + "	$" + entry.getValue().getCost());
		}
		Communication.communicate(SELECT_PROMPT);
	}

}
