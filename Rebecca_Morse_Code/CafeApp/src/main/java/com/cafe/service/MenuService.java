package com.cafe.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Formatter;

import com.cafe.dao.CafeDAOImplementation;
import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.util.Communication;

public class MenuService {
	
	public static final String MENU_TITLE = "The Cat Cafe Menu:\n";
	public static final String SELECT_PROMPT = "\nTo select an Item, enter the number in parentheses.";
	DecimalFormat df = new DecimalFormat("#.##");
	
	public static Menu makeMenu() {

		CafeDAOImplementation cafeDAO = new CafeDAOImplementation();
		List<FoodItem> myFoodItems = cafeDAO.SelectAllFoodItems();
		Map<Integer, FoodItem> menuContents = new HashMap<Integer, FoodItem>();
		for(FoodItem item: myFoodItems) {
			menuContents.put(item.getId(), item);
		}

		Menu menu = new Menu(menuContents);
		return menu;
	}
	
	public static void displayMenu(Menu menu) {
		Communication.communicate(MENU_TITLE);

		for (Map.Entry<Integer, FoodItem> entry : menu.getMenu().entrySet()) {
			
			String selector = "(" + entry.getKey()+ ") ";
			String dishName = entry.getValue().getName();
			String description = entry.getValue().getDescription();
			String price = String.format("%.2f", entry.getValue().getCost());			
			
			System.out.printf("%-2s",selector);
			System.out.printf("%-30s",dishName);
			System.out.printf("%-80s",description);
			System.out.printf("$%6s",price);
			System.out.println();
		}
		Communication.communicate(SELECT_PROMPT);
	}

}
