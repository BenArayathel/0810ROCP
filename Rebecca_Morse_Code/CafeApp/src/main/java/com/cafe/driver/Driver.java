package com.cafe.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.models.Customer;
import com.cafe.models.FoodItem;
import com.cafe.service.Menu;
import com.cafe.service.Order;

public class Driver {

	public static final String WELCOME_MESSAGE = "Welcome to Cat Cafe! To place an order, Enter your Name:";
	public static final String GREETING = "Hello, ";
	public static final String ORDER_PROMPT = "What would you like to order?";
	public static final String MENU_TITLE = "The Cat Cafe Menu:";
	public static final String SELECT_PROMPT = "To select an Item, enter the number in parentheses.";
	public static final String QUANTITY_PROMPT_ONE = "How many ";
	public static final String QUANTITY_PROMPT_TWO = "s would you like?";
	public static final String DISPLAY_ORDER_TITLE = "Here is your order so far:";
	public static final String CONTINUE_ORDER_PROMPT = "Enter \n(A) To Add Items \n(R) To Remove Items \n(C) To Check out.";
	public static final String ADD_ITEMS_PROMPT = "What would you like to add to your order?";
	public static final String REMOVE_ITEMS_PROMPT = "What would you like to remove from your order?";
	public static final String ORDER_TOTAL_PREFIX = "Total for order:";
	public static final String FINALIZE_ORDER_PROMPT = "Enter (U) To Update or change your order \nEnter (P) To Pay and complete your order.";
	public static final String THANK_YOU = "Thank you for visiting the Cat Cafe, Come again soon!";
	public static final String ENTER_VALID_OPTION = "Please enter a valid option";

	private static String action;
	static int currentOrderNumber = 1;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		communicate(WELCOME_MESSAGE);

		Customer customer = establishCustomer(takeInput(sc));

		communicate(GREETING + " " + customer.getName() + "!");

		Menu menu = makeMenu();

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
				checkout();
				break;
			default:
				communicate(ENTER_VALID_OPTION);
				break;
			}
		}
		sc.close();

	}

	private static void presentMenuAndUpdateOrder(Scanner sc, Customer customer, Menu menu) {
		presentMenu();
		
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

	private static void checkout() {
//		communicate(ORDER_TOTAL_PREFIX + "   $" + total)
		communicate(THANK_YOU);
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

	private static void presentMenu() {
		communicate(MENU_TITLE);
		displayMenu(makeMenu());
		communicate(SELECT_PROMPT);
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

	private static Order startOrder() {
		Map newOrderMap = new HashMap<FoodItem, Integer>();
		Order order = new Order(currentOrderNumber, newOrderMap);
		currentOrderNumber++;
		return order;
	}

	public static Menu makeMenu() {

		Map<Integer, FoodItem> menuContents = new HashMap<Integer, FoodItem>();

		FoodItem water = new FoodItem("Water", "Beverage", "Liquid Refreshment at its' finest!", 0);
		FoodItem lemonade = new FoodItem("Lemonade", "Beverage", "The tastiest Summertime Drink", 2);
		FoodItem veggieBurger = new FoodItem("Veggie Burger", "Entree",
				"Our House-made Veggie Burgers, served with hand-cut fries.", 10);
		FoodItem pasta = new FoodItem("Pasta Supreme", "Entree", "House made pasta with the freshest Pesto around.", 7);
		FoodItem asparagus = new FoodItem("Asparagus Spear", "Side", "Only the freshest!", 17);
		FoodItem cococadoShake = new FoodItem("Cococado Vegan Milkshake", "Dessert",
				"Made with rice dream ice cream, bananas, coconut and avocado. You know you love it!", 4);
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
		for (Map.Entry<Integer, FoodItem> entry : menu.getMenu().entrySet()) {
			System.out.println(
					"(" + entry.getKey() + ") " + entry.getValue().getName() + " - " + entry.getValue().getDescription() + "	$" + entry.getValue().getCost());
		}
	}

}
