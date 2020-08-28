package com.cafe.driver;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.cafe.dao.CafeDAOImplementation;
import com.cafe.models.Menu;
import com.cafe.models.Order;
import com.cafe.service.MenuService;
import com.cafe.service.OrderTaker;
import com.cafe.util.Communication;

public class Driver {

	public static final String WELCOME_MESSAGE = "Welcome to Cat Cafe! What's your Name?";
	public static final String GREETING = "Hello, ";
	public static final String ORDER_PROMPT = "What would you like to order?\n";

	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Communication.communicate(WELCOME_MESSAGE);
		
		String customer = OrderTaker.takeInput(sc);
		
		Order newOrder = OrderTaker.startOrder(customer);
		
		Communication.communicate(GREETING + " " + customer + ", " + ORDER_PROMPT);

		Menu menu = MenuService.makeMenu();

		OrderTaker.takeOrder(sc, newOrder, menu);
		
		sc.close();

	}
}