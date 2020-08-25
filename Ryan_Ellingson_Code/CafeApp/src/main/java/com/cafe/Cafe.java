package com.cafe;

import java.util.ArrayList;
import java.util.Scanner;

public class Cafe {
	private ArrayList<Order> orders;
	private Menu menu;
	
	public Cafe() {
		super();
		this.menu = new Menu();
		this.orders = new ArrayList<>();
	}
	
	
	
	public void takeOrder(Scanner sc) {
		System.out.println("Please enter your name");
		String name = sc.nextLine();
		Order newOrder = new Order(name);
		System.out.println(this.menu);
		boolean finished = false;
		while (!finished) {
			boolean isValid1 = false;
			while (!isValid1) {
				System.out.println("Please choose one of the items from the menu or type 'done' if finished");
				String choice = sc.nextLine();
				if (choice.equals("done")) {
					isValid1 = true;
					System.out.println("Order summary:");
					System.out.println(newOrder);
					System.out.println("Total price: $" + newOrder.getTotal(menu));
					boolean isValid2 = false;
					while (!isValid2) {
						System.out.println("Is this correct or would you like to start over? Type 'correct' or 'start over'");
						String option = sc.nextLine();
						switch(option) {
						case "correct":
							finished = true;
							isValid2 = true;
							break;
						case "start over":
							newOrder.clearOrder();
							isValid2 = true;
							break;
						default:
							break;
						}
					}
				} else {
					for (String itemName : this.menu.getMenu().keySet()) {
						if (choice.equals(itemName)) {
							newOrder.addItem(itemName);
							System.out.println(itemName + " successfully added!");
							isValid1 = true;
						}
					}
				}
			}
			
		}
		orders.add(newOrder);
	}
	
	public ArrayList<Order> getOrders() {
		return this.orders;
	}
}
