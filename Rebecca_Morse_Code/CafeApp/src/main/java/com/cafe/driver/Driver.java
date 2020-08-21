package com.cafe.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.models.Customer;
import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.models.Order;
import com.cafe.service.MenuService;

public class Driver {

	public static final String WELCOME_MESSAGE = "Welcome to Cat Cafe! To place an order, Enter your Name:";
	public static final String GREETING = "Hello, ";
	public static final String ORDER_PROMPT = "What would you like to order?";
	public static final String QUANTITY_PROMPT_ONE = "How many ";
	public static final String QUANTITY_PROMPT_TWO = "s would you like?";
	public static final String DISPLAY_ORDER_TITLE = "Here is your order:";
	public static final String CONTINUE_ORDER_PROMPT = "Enter \n(A) To Add Items \n(R) To Remove Items \n(C) To Check out.";
	public static final String ADD_ITEMS_PROMPT = "What would you like to add to your order?";
	public static final String REMOVE_ITEMS_PROMPT = "What would you like to remove from your order?";
	public static final String ORDER_TOTAL_PREFIX = "Total for order:";
//	public static final String FINALIZE_ORDER_PROMPT = "Enter (U) To Update or change your order \nEnter (P) To Pay and complete your order.";
	public static final String THANK_YOU = "Thank you for visiting the Cat Cafe, ";
	public static final String COME_AGAIN = ", Come again soon!";
	public static final String ENTER_VALID_OPTION = "Please enter a valid option";
	

	private static String action;
	static int currentOrderNumber = 1;
	private static MenuService menuService = new MenuService();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		communicate(WELCOME_MESSAGE);

		Customer customer = establishCustomer(takeInput(sc));

		communicate(GREETING + " " + customer.getName() + "!\n");

		Menu menu = menuService.makeMenu();

		takeOrder(sc, customer, menu);
		
		sc.close();

	}

	private static void takeOrder(Scanner sc, Customer customer, Menu menu) {
		presentMenuAndUpdateOrder(sc, customer, menu);
		
		boolean stillOrdering = true;
		
		while (stillOrdering) {
			String selection = takeInput(sc);
			switch (selection.toUpperCase()) {
			case "A":
				communicate(ADD_ITEMS_PROMPT);
				presentMenuAndUpdateOrder(sc, customer, menu);
				break;
			case "R":
				communicate(REMOVE_ITEMS_PROMPT);
				presentMenuAndUpdateOrder(sc,customer, menu);
				break;
			case "C": stillOrdering = false;
				checkout(customer);
				break;
			default:
				communicate(ENTER_VALID_OPTION);
				break;
			}
		}
	}

	
	private static Order startOrder() {
		Map newOrderMap = new HashMap<FoodItem, Integer>();
		Order order = new Order(currentOrderNumber, newOrderMap);
		currentOrderNumber++;
		return order;
	}
	
	private static void presentMenuAndUpdateOrder(Scanner sc, Customer customer, Menu menu) {
		menuService.displayMenu(menu);
		
		int itemKey = Integer.parseInt(takeInput(sc));
		switch(itemKey) {
			case 1: case 2: case 3: case 4: case 5: case 6: case 7:
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

	private static void promptforNextStep() {
		communicate(CONTINUE_ORDER_PROMPT);

	}

	private static void displayOrder(Order order) {
		communicate(DISPLAY_ORDER_TITLE);
		for (Map.Entry<FoodItem, Integer> entry : order.getOrderContents().entrySet()) {
			communicate(
					entry.getValue() + " " + entry.getKey().getName() + 
					"	$" + entry.getKey().getCost() + " (each)");
		}
		float total = getOrderTotal(order);
		communicate(ORDER_TOTAL_PREFIX + "$" + total);
	}

	private static void checkout(Customer customer) {
		Order order = customer.getOrder();
		displayOrder(order);
		communicate(THANK_YOU + customer.getName() + COME_AGAIN);
	}

	private static float getOrderTotal(Order order) {
		float total = 0;
		for (Map.Entry<FoodItem,Integer> entry: order.getOrderContents().entrySet()) {
			float itemTotal = entry.getKey().getCost() * entry.getValue();
			total = total + itemTotal;
		}
		return total;
	}

	private static void updateItemQtyOnOrder(Order order, FoodItem item, int quantity) {
		Map<FoodItem, Integer> orderMap = order.getOrderContents();
		orderMap.put(item, quantity);
	}


	public static void communicate(String string) {
		System.out.println(string);
	}

	public static String takeInput(Scanner sc) {
		String input = sc.nextLine();
		return input;
	}

	private static Customer establishCustomer(String takeInput) {
		Customer customer = new Customer(takeInput, startOrder());
		return customer;
	}
	




}
