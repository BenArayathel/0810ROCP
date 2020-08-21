package com.cafe.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.models.Customer;
import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.models.Order;

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

	public static void takeOrder(Scanner sc, Customer customer, Menu menu) {
		askForNextOrderItem(sc, customer, menu);

		boolean stillOrdering = true;

		while (stillOrdering) {
			String selection = takeInput(sc);
			switch (selection.toUpperCase()) {
			case "A":
				communicate(ADD_ITEMS_PROMPT);
				askForNextOrderItem(sc, customer, menu);
				break;
			case "R":
				communicate(REMOVE_ITEMS_PROMPT);
				askForNextOrderItem(sc, customer, menu);
				break;
			case "C":
				stillOrdering = false;
				checkout(customer);
				break;
			default:
				communicate(ENTER_VALID_OPTION);
				break;
			}
		}
	}

	private static void askForNextOrderItem(Scanner sc, Customer customer, Menu menu) {
		menuService.displayMenu(menu);

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
			communicate(QUANTITY_PROMPT_ONE + item.getName() + QUANTITY_PROMPT_TWO);
			int quantity = Integer.parseInt(takeInput(sc));
			updateItemQtyOnOrder(customer.getOrder(), item, quantity);
			break;
		default:
			communicate(ENTER_VALID_OPTION);
			break;
		}

		displayOrder(customer.getOrder());

		promptforNextStep();
	}

	public static String takeInput(Scanner sc) {
		String input = sc.nextLine();
		return input;
	}

	private static void checkout(Customer customer) {
		Order order = customer.getOrder();
		displayOrder(order);
		communicate(THANK_YOU + customer.getName() + COME_AGAIN);
	}

	public static void communicate(String string) {
		System.out.println(string);
	}

	private static void updateItemQtyOnOrder(Order order, FoodItem item, int quantity) {
		Map<FoodItem, Integer> orderMap = order.getOrderContents();
		orderMap.put(item, quantity);
	}

	private static void displayOrder(Order order) {
		communicate(DISPLAY_ORDER_TITLE);
		for (Map.Entry<FoodItem, Integer> entry : order.getOrderContents().entrySet()) {
			communicate(
					entry.getValue() + " " + entry.getKey().getName() + "	$" + entry.getKey().getCost() + " (each)");
		}
		float total = getOrderTotal(order);
		communicate(ORDER_TOTAL_PREFIX + "$" + total);
	}
	
	private static void promptforNextStep() {
		communicate(CONTINUE_ORDER_PROMPT);

	}

	private static float getOrderTotal(Order order) {
		float total = 0;
		for (Map.Entry<FoodItem,Integer> entry: order.getOrderContents().entrySet()) {
			float itemTotal = entry.getKey().getCost() * entry.getValue();
			total = total + itemTotal;
		}
		return total;
	}

	public static Order startOrder(int currentOrderNumber) {
		Map newOrderMap = new HashMap<FoodItem, Integer>();
		Order order = new Order(currentOrderNumber, newOrderMap);
		currentOrderNumber++;
		return order;
	}
	
}
