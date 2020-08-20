package com.cafe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CafeClass {
	//int integerNew;
	//String inputString;
	String clientName;
	String clientOrderItem;
	String employeeName;
	String employeePW;
	
	//Map<String,Integer> orderHashMap = new HashMap<String,Integer>();
	
	public void mainDisplay() {
		//This is the main manual
		System.out.println("Welcome to Mini Cafe");
		System.out.println("Are you an employee or a client");
		System.out.println("Please type 1 for employee");
		System.out.println("Please type 2 for client");
		System.out.println("Please type 3 to exit the program");		
	}
	
	//client
	public void clientLoginDisplay() {
		System.out.println("Please enter your name first ");
	}
	
	public void areYouDownWithYourOrderDisplay() {
		System.out.println("Are you down with your order? Please Type 'Yes' to confirm your order, or type 'No' to go to previous menu ");
	}
	
	public void saveClientName(String clientName) {
		this.clientName=clientName;
	}
	
	public String getClientName() {
		return this.clientName;
	}
	
	
	
	//Employee	
	public void employeeLoginDisplay() {
		System.out.println("Please enter your username: ");
	}
	
	public void saveEmployeeName(String employeeName) {
		this.employeeName=employeeName;
	}
	
	public String getEmployeeName() {
		return this.employeeName;
	}
	
	/*
	public void employeeUserPWDisplay() {
		System.out.println("Please enter your password: ");
	}
	*/
	
	public void saveEmployeePW(String employeePW) {
		this.employeePW=employeePW;
	}
	
	public String getEmployeePW() {
		return this.employeePW;
	}
	
	
	public void menuDisplay() {
		//This is the user order manual
		System.out.println("Mini Cafe's Menu ");
		System.out.println("Main Course: 1. Burges $5/each, 2. Fries $3/each\"");
		System.out.println("Drinks: 3. Orang Juice $2/cup, 4. Tea $1/cup");
		System.out.println("Please pick up the item by typing the corresponding number: ");
	}
	
	public String getOrderItem() {
		return this.clientOrderItem;
	}
	public String getOrderItem (String numString) {
		//Generate a specific string from the manual
		String s;
		if (numString.equals("1")) {
			s = "burges";
		}else if (numString.equals("2")) {
			s = "Fries";
		}else if (numString.equals("3")) {
			s = "orange juice";
		}else {
			s = "tea";
		}
		return s;
	}
	
	public void orderQuantityDisplay(String foodName) {
		System.out.println("Thank you for chosing " + foodName);
		System.out.println("Please let us know how many " + foodName +"s that you would like to order: ");
	}
	
		
	public void clientOrderConfirmationDisplay() {
		System.out.println("Have you completed your order yet? ");
		System.out.println("Please type 1 if you completed and confirmed your order, ");
		System.out.println("or you can type 2 to go back to the previous menu ");
	}
	
	//css.clientOrderCompleteDisplay();
	public void clientOrderCompleteDisplay() {
		System.out.println("Your order is in the process, please be patient ");
	}
	public int findNumOfOrder(int numOrder, String s) {
		//This is the actual ordering manual to show the quantity
		return 0;
	}
	
	
	
	public void takeOrder(String quantityString) {
		//Scanner scOrder = new Scanner(System.in);
		//String sString;
		//boolean flag = true;
		
		//if (userString.equals()) {
		//this.orderItem = "Burges";
		System.out.println("Please tell me the number of your burgers that you are ordering");
		//sString = scOrder.nextLine();
		
		//System.out.println("you requested " + quantityString + " Burges");
		//System.out.println(Integer.parseInt(quantityString)*2);
		
		while (true) {
			System.out.println("You have just ordered " + quantityString + " burges");
			System.out.println("Please type 1 to confirm the order, type 2 to mordify your order");
			System.out.println("or type 3 to go back to your main manual");
			
			
			if (Integer.parseInt(quantityString)==1) {
				//orderHashMap.put("burges", Integer.parseInt(quantityString));
				
				//System.out.println("Your order of " + orderHashMap.get("burges") + " burges is confirmed");
				flag = false;
				break;
			}
		}
		//}
	}

}
