package com.cafe.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.models.Customer;
import com.cafe.models.FoodItem;
import com.cafe.models.Menu;
import com.cafe.models.Order;
import com.cafe.service.MenuService;
import com.cafe.service.OrderTaker;
import com.cafe.util.Communication;

public class Driver {

	public static final String WELCOME_MESSAGE = "Welcome to Cat Cafe! To place an order, Enter your Name:";
	public static final String GREETING = "Hello, ";
	public static final String ORDER_PROMPT = "What would you like to order?";
//	public static final String FINALIZE_ORDER_PROMPT = "Enter (U) To Update or change your order \nEnter (P) To Pay and complete your order.";
	

//	private static String action;
	static int currentOrderNumber = 1;
	private static MenuService menuService = new MenuService();
	private static OrderTaker orderTaker = new OrderTaker();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Communication.communicate(WELCOME_MESSAGE);
		
		Order newOrder = OrderTaker.startOrder(OrderTaker.takeInput(sc));
		
//		Customer customer = establishCustomer(orderTaker.takeInput(sc));

		Communication.communicate(GREETING + " " + newOrder.getCustomer().getName() + "!\n");

		Menu menu = menuService.makeMenu();

		OrderTaker.takeOrder(sc, newOrder.getCustomer(), menu);
		
		sc.close();

	}


//	private static Customer establishCustomer(String takeInput) {
//		Customer customer = new Customer(takeInput, orderTaker.startOrder(takeInput).getOrderId());
//		return customer;
//	}
	




}
