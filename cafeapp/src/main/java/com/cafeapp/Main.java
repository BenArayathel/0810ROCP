package com.cafeapp;
import com.cafeapp.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.ArrayUtils;


public class Main {

	private static String action;
	private static String category = "main";
	private static HashMap<Integer, Order> Orderlist = new HashMap<Integer, Order>();
	
	public static void main(String[] args) {
		Order currentOrder = new Order();
		Menu.generate();
		Scanner sc = new Scanner(System.in);
		action = "start";
		
		do {
			switch (action) {
				case "start":
					currentOrder = new Order();
					action = start(sc);
					continue;
				case "order":
					action = order(sc, category, currentOrder);
					continue;
				case "confirm":
					action = confirm(sc, currentOrder);
					continue;
//				case "name":
//					action = name(sc, currentOrder);
//					continue;
				case "view":
					action = view(sc);			//in the future, consider making Scanner part of the console itself
				default:
					action = "exit";
			}
			action = (action != null) ? action : "exit";
		} while (!action.equals("exit"));
	}
	
	public static String start(Scanner sc) {
		//Options for creating new order, seeing existing order, or employee view (stretch goal)
		String[] options = {"order", "view"};
		String input = console(sc, options);
		return input;
	}
	
	public static String order(Scanner sc, String cat, Order currentOrder) {
		/*
		 * Commence ordering
		 * Pull up menu
		 * Await item input
		 * Add item to OrderList
		 * Repeat
		 * Break by command
		 */
		String input = null;
		if (currentOrder.getOrder().isEmpty()) {
			input = console(sc, (cat.equals("main")) ? Menu.mainMenu() : Menu.menuCategory(cat));
		} else {
			input = console(sc, (cat.equals("main"))
								? ArrayUtils.add(Menu.mainMenu(), "Confirm") 
								: ArrayUtils.add(Menu.menuCategory(cat), "Confirm"));
		}
		
		if (input.toLowerCase().equals("confirm")) {
			category = "main";
			return "confirm";
		}
		if (input.toLowerCase().equals("return")) {
			switch (category) {
				case "main":
					return "start";
				default:
					category = "main";
					return "order";
			}
		}
		if (cat.equals("main")) {
			category = input;
			return "order";
		} else {
			currentOrder.makeOrder(sc, cat, input);
			category = cat;
			return "order";
		}
			
	}
	
	public static String confirm(Scanner sc, Order currentOrder) {
		HashMap<Item, Integer> list = currentOrder.getOrder();
		HashSet<String> receipt = new HashSet<>();
		for (Item item:list.keySet()) {
			receipt.add(item.toString() + " x " + list.get(item));
		}
		printout(receipt.toArray(new String[0]), true);
		HashMap<String, String> options = new HashMap<>();
		options.put("command", "Confirm Order? Y/N/Delete");
		HashMap<String, String> command = console(sc, options);
		switch (command.get("command")) {
			case "Y":
				currentOrder.setName(sc);
				int uniqueid;
				do {
					uniqueid = (int) (Math.random() * 100);
				} while (getOrderIDs().contains(uniqueid));
				addOrderlist(uniqueid, currentOrder);
				
				return "start";
			case "N":
				return "order";
			case "Delete":
				currentOrder.clearOrder();
				return "start";
			default:
				return "order";
		}
	}
	
	public static String view(Scanner sc) {
		
		return null;
	}
	
	private static Set<Integer> getOrderIDs() {
		return Orderlist.keySet();
	}
	
	private static HashMap<Integer, Order> getOrderlist() {
		return Orderlist;
	}

	private static void addOrderlist(int id, Order newOrder) {
		Orderlist.put(id, newOrder);
	}
	
//	public static String name(Scanner sc, Order currentOrder) {
//		
//		
//		return "start";
//	}

	// Console Controls
	public static String console(Scanner sc, String[] options) {
		boolean valid = false;
		String input = null;
		printout(options);
		while (!(valid)) {
			System.out.print("> ");
			input = sc.nextLine();
			if (Arrays.asList(options).contains(input) || input.toLowerCase().equals("return")) {
				valid = true;
			} else {
				System.out.println("Invalid Command");
				printout(options);
			}
		}
		return input;
	}
	
	public static HashMap<String, String> console(Scanner sc, HashMap<String, String> requests) {
		HashMap<String, String> filled = new HashMap<>();
		for (String request:requests.keySet()) {
			boolean hasContent = false;
			String input = null;
			while (!(hasContent)) {
				System.out.print(requests.get(request) + ": ");
				input = sc.nextLine();
				if (StringUtils.isNotEmpty(input)) {
					break;
				} else {
					System.out.println("Please fill field");
				}
			}
			filled.put(request, input);
		}
		
		return filled;
	}
	
	public static HashMap<String, Integer> console(Scanner sc, HashMap<String, String> requests, int a) {
		HashMap<String, Integer> filled = new HashMap<>();
		for (String request:requests.keySet()) {
			boolean hasContent = false;
			int input = 0;
			while (!(hasContent)) {
				System.out.print(requests.get(request) + ": ");
				try {
					input = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception NumberFormatException) {
					System.out.println("Please input number");
				}
			}
			filled.put(request, input);
		}
		
		return filled;
	}
	
	private static void printout(String[] printable) {
		System.out.print("Return");
		for(String current:printable) {
			System.out.print(" | " + StringUtils.capitalize(current));
		}
		System.out.println("");
	}
	
	private static void printout(String[] printable, boolean type) {
		if (type == true) {
			for (String current:printable) {
				System.out.println(current);
				System.out.println("");
			}
		}
	}

}
