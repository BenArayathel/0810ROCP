package com.cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Driver {
	public static void main(String[] args) {
		//greetingManual;
		//System.out.println("Hello World!");
		String clientName;
		//String mainCourseName;
		//int mainCourseQuantity;
		//String drinkName;
		//int drinkQuantity;
		String clientOrderItem;
		int clientOrderQuantity;
		//String userString;
		
		//int clientOrderQuantity=0;
		boolean flagMain=true;
		boolean flagMenu=true;
		boolean flagConfirmOrder=true;
		boolean flagClientOrderConfirmation=true;
		boolean flagExit=false;
		
		UserClass client = new UserClass();
		//Map<String,Object> clientNameHashMap1 = new HashMap<String,Object>();
		//Map<String,Object> clientNameHashMap2 = new HashMap<String,Object>();
		//ArrayList<String> clientArrayList = new ArrayList<>();
		//ArrayList<Object> orderArrayList = new ArrayList<>();
		//HashMap<String,Integer> clientMainCourseHashMap = new HashMap<String,Integer>();
		//HashMap<String,Integer> clientDrinkHashMap = new HashMap<String,Integer>();
		HashMap<String,Integer> clientOrderHashMap = new HashMap<String,Integer>();
		HashMap<String,Object> clientHashMap = new HashMap<String, Object>();
		
		
		//clientOrderHashMap.put(clientOrderItem,clientOrderQuantity);
		//clientNameHashMap.put(clientName, clientOrderHashMap);
		
		/*	
		client.setClientName("John");
		System.out.println(client.getClientName());
		clientMainCourseHashMap.put("berges", 4);
		//System.out.println(clientMainCourseHashMap);
		clientMainCourseHashMap.put("fries", 2);
		clientMainCourseHashMap.put("fries", 3);
		clientMainCourseHashMap.put("berges", 1);
		clientMainCourseHashMap.replace("berges", 2);
		System.out.println(clientMainCourseHashMap);
		clientDrinkHashMap.put("orange juice", 1);
		clientDrinkHashMap.put("tea", 2);
		clientNameHashMap1.put(client.getClientName(), clientMainCourseHashMap);
		clientNameHashMap2.put(client.getClientName(), clientDrinkHashMap);
		
		client.setClientName("Mary");
		System.out.println(client.getClientName());
		clientMainCourseHashMap.put("berges", 4);
		//System.out.println(clientMainCourseHashMap);
		clientMainCourseHashMap.put("fries", 2);
		clientMainCourseHashMap.put("fries", 3);
		clientMainCourseHashMap.put("berges", 1);
		//clientMainCourseHashMap.replace("berges", 1);
		System.out.println(clientMainCourseHashMap);
		clientDrinkHashMap.put("orange juice", 1);
		clientDrinkHashMap.put("tea", 0);
		clientNameHashMap1.put(client.getClientName(), clientMainCourseHashMap);
		clientNameHashMap2.put(client.getClientName(), clientDrinkHashMap);
		System.out.println(clientNameHashMap1);
		System.out.println(clientNameHashMap2);
		//System.out.println(clientDrinkHashMap);
		//System.out.println(clientNameHashMap);
		System.out.println("Hello World!");
		client.setClientName("John");
		System.out.println(client.getClientName());
		
		client.setMainCourse("berges", 1);
		System.out.println(client.mainCourseHashMap);
		
		client.setDrink("orange juice", 2);
		System.out.println(client.drinkHashMap);
		
		*/
	//}
//}
		Scanner sc = new Scanner(System.in);
		//public void displayManul(int i) {
		CafeClass css = new CafeClass();
		
		//css.displayManul(10);
		
		while (flagMain) {
			css.mainDisplay();
			String userString=sc.nextLine();
			
			//flagMain=false;

			if (userString.equals("1")) {
				//call the method in UserClass
				//public String getString (String s) {
				css.employeeLoginDisplay();
				userString = sc.nextLine();
				//clientArrayList.add(userString);
				
				//css.saveEmployeeName(userString);
				//css.employeeUserPWDisplay();
				//userString = sc.nextLine();
				//css.saveEmployeeUserPW(userString);
				//userString=sc.nextLine();
				//System.out.println("Please type your password: ");
				//userString=sc.nextLine();
				//System.out.println(UserClass.getString(userString));
				//System.out.print(user);
				//userString=sc.nextLine();
			} else if (userString.equals("2")) {
				//get into CafeClass
				//System.out.println("Hi2");
				css.clientLoginDisplay();
				userString=sc.nextLine();//pickup from the four choices
				clientName=userString;
				menu:
				while (flagMenu) {
					
					css.menuDisplay();
					//css.takeOrder(userString);
					userString = sc.nextLine();//burges
					//choice from 1,2,3,4
					if (userString.equals("1")){
						//|| userString.equals("2") || userString.equals("3") ||userString.equals("4")){
						System.out.println("How many burges that you want to order: ");
						userString=sc.nextLine();
						clientOrderQuantity= Integer.parseInt(userString);
						clientOrderHashMap.put("burges", clientOrderQuantity);
						System.out.println("You have just ordered " + clientOrderHashMap.get("burges") + " burges.");
						//css.clientConfirmationDisplay()
						//There are two options 1. Yes--got to confirmation page
						//2 No. go to preivous menu display
						while (flagClientOrderConfirmation) {
							css.areYouDownWithYourOrderDisplay();
							userString=sc.nextLine();
							if (userString.equals("Yes")) {//confirmed your order
								//save data to orderHashMap
								//save data to userHashMap
								clientHashMap.put(clientName, clientOrderHashMap);
								//clientHashMap.
								//int clientOrderHashMapSize = clientOrderHashMap.size();
								Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
								for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
									System.out.println("You" +
											" have ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
								}
								//return to the main display
								css.mainDisplay();
								userString=sc.nextLine();
								
								flagClientOrderConfirmation=false;
								flagMenu=false;
								flagMain=true;
							}else if (userString.equals("No")) {
								continue menu;
								//flagClientOrderConfirmation=false;
								//flagMenu=false;
								//flagMain=false;
								//css.menuDisplay();
								
							}else {
								flagClientOrderConfirmation=true;
								flagMenu=true;
								//continue;
							}
						}
					}else if (userString.equals("2")) {
						System.out.println("How many fries that you want to order: ");
						userString=sc.nextLine();
						clientOrderQuantity= Integer.parseInt(userString);
						clientOrderHashMap.put("fries", clientOrderQuantity);
						System.out.println("You have just ordered " + clientOrderHashMap.get("fries") + " fries.");
						
					}else if (userString.equals("3")) {
						System.out.println("How many cup of orange juice drink that you want to order: ");
						userString=sc.nextLine();
						clientOrderQuantity= Integer.parseInt(userString);
						System.out.println(clientOrderQuantity);
						clientOrderHashMap.put("orange juice", clientOrderQuantity);
						System.out.println("You have just ordered " + clientOrderHashMap.get("orange juice") + " cups of orange juice.");
						
					}else if (userString.equals("4")) {
						System.out.println("How many cup of tea that you want to order: ");
						userString=sc.nextLine();
						clientOrderQuantity= Integer.parseInt(userString);
						System.out.println(clientOrderQuantity);
						clientOrderHashMap.put("tea", clientOrderQuantity);
						System.out.println("You have just ordered " + clientOrderHashMap.get("tea") + " cups of tea.");
					}else {
						System.out.println("Hi, I am here");
						css.menuDisplay();
						//css.mainDisplay();
						//userString=sc.nextLine();					
					}
				}
			}
		}
		sc.close();
		System.out.println("Thank you for visiting Mini Cafe. See you next time!");
	}
		
}

