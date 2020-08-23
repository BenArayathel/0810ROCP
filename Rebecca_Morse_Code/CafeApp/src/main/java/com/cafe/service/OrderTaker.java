package com.cafe.service;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.dao.CafeDAOImplementation;
import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.models.Order;
import com.cafe.util.*;

public class OrderTaker {

	public static final String ADD_ITEMS_PROMPT = "What would you like to add to your order?";
	public static final String REMOVE_ITEMS_PROMPT = "What would you like to remove from your order?";
	public static final String ENTER_VALID_OPTION = "Please enter a valid option";
	public static final String QUANTITY_PROMPT_ONE = "How many ";
	public static final String QUANTITY_PROMPT_TWO = "s would you like?";
	public static final String THANK_YOU = "Thank you for visiting the Cat Cafe, ";
	public static final String COME_AGAIN = ", Come again soon!";
	public static final String DISPLAY_ORDER_TITLE = "Here is your order:";
	public static final String ORDER_TOTAL_PREFIX = "Total for order:";
	public static final String CONTINUE_ORDER_PROMPT = "Enter \n(A) To Add Items \n(R) To Remove Items \n(C) To Check out.";

	
	private static MenuService menuService = new MenuService();
	DecimalFormat df = new DecimalFormat("#.##");


	public static String takeInput(Scanner sc) {
		String input = sc.nextLine();
		return input;
	}

	public static Order startOrder(String customer) {

		CafeDAOImplementation cafeDAO = new CafeDAOImplementation();

		HashMap<FoodItem, Integer> newOrderMap = new HashMap<FoodItem, Integer>();

		int orderNumber = cafeDAO.insertOrder(customer);
		Order order = new Order(orderNumber, newOrderMap, customer);
		return order;

	}

	public static void takeOrder(Scanner sc, Order order, Menu menu) {
		askForNextOrderItem(sc, order, menu);

		boolean stillOrdering = true;

		while (stillOrdering) {
			String selection = takeInput(sc);
			switch (selection.toUpperCase()) {
			case "A":
				Communication.communicate(ADD_ITEMS_PROMPT);
				askForNextOrderItem(sc, order, menu);
				break;
			case "R":
				Communication.communicate(REMOVE_ITEMS_PROMPT);
				askForNextOrderItem(sc, order, menu);
				break;
			case "C":
				stillOrdering = false;
				checkout(order);
				break;
			default:
				Communication.communicate(ENTER_VALID_OPTION);
				break;
			}
		}
	}

	private static void askForNextOrderItem(Scanner sc, Order order, Menu menu) {
		MenuService.displayMenu(menu);

		int itemKey = Integer.parseInt(takeInput(sc));
		switch (itemKey) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
			FoodItem item = menu.getMenu().get(itemKey);
			Communication.communicate(QUANTITY_PROMPT_ONE + item.getName() + QUANTITY_PROMPT_TWO);
			int quantity = Integer.parseInt(takeInput(sc));
			updateItemQtyOnOrder(order, item, quantity);
			break;
		default:
			Communication.communicate(ENTER_VALID_OPTION);
			break;
		}

		displayOrder(order);

		promptforNextStep();
	}

	private static void updateItemQtyOnOrder(Order order, FoodItem item, int quantity) {
		Map<FoodItem, Integer> orderMap = order.getOrderContents();
		orderMap.put(item, quantity);
	}

	private static void displayOrder(Order order) {
		Communication.communicate(DISPLAY_ORDER_TITLE);
		for (Map.Entry<FoodItem, Integer> entry : order.getOrderContents().entrySet()) {
			String cost = String.format("%.2f", entry.getKey().getCost());
			Communication.communicate(
					entry.getValue() + " " + entry.getKey().getName() + "	$" + cost + " (each)");
		}
		float total = getOrderTotal(order);
		String displayTotal = String.format("%.2f", total);
		Communication.communicate(ORDER_TOTAL_PREFIX + "$" + displayTotal);
	}

	private static void promptforNextStep() {
		Communication.communicate(CONTINUE_ORDER_PROMPT);
	}

	private static float getOrderTotal(Order order) {
		float total = 0;
		for (Map.Entry<FoodItem, Integer> entry : order.getOrderContents().entrySet()) {
			float itemTotal = entry.getKey().getCost() * entry.getValue();
			total = total + itemTotal;
		}
		return total;
	}

	private static void checkout(Order order) {
		displayOrder(order);
		Communication.communicate(THANK_YOU + order.getCustomer() + COME_AGAIN);

	}

}
