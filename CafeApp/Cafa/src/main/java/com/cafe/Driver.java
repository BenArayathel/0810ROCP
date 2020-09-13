package com.cafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Driver {
	public static void main(String[] args) {
		
		String clientName;
		String clientOrderItem;
		int clientOrderQuantity;
		boolean flagMain=true;
		boolean flagMenu=true;
		boolean flagConfirmOrder=true;
		boolean flagClientOrderConfirmation=true;
		
		UserClass client = new UserClass();
		ArrayList<String> employeeNameArrayList = new ArrayList<>();
		HashMap<String,Integer> menuHashMap = new HashMap<String,Integer>();
		HashMap<String,Integer> clientOrderHashMap = new HashMap<String,Integer>();
		HashMap<String,Object> clientHashMap = new HashMap<String, Object>();
		
	
		menuHashMap.put("burges", 5);
		menuHashMap.put("fries", 3);
		menuHashMap.put("orange juice", 2);
		menuHashMap.put("tea", 1);
		
		Scanner sc = new Scanner(System.in);
		CafeClass css = new CafeClass();
		
			main:
			while (flagMain) {
				css.mainDisplay();
				String userString=sc.nextLine();
				int sum = 0;
				
				if (userString.equals("1")) {
					css.employeeLoginDisplay();
					userString = sc.nextLine();
					employeeNameArrayList.add(userString);
					while (true) {
						//clientHashMap.
						if (clientHashMap.size()!=0) {
							Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
							Set<HashMap.Entry<String,Object>> clientHashMapEntrySets = clientHashMap.entrySet();
							for (HashMap.Entry<String,Object> clientHashMapEntrySet : clientHashMap.entrySet()) {
								//if (clientHashMapEntrySet.getKey().equals(clientName)) {
								System.out.print("Customer " + clientHashMapEntrySet.getKey());
								int rate=0;
								for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
									System.out.println(
											" has ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
									
									sum = sum + clientOrderEntrySet.getValue()*menuHashMap.get(clientOrderEntrySet.getKey());
									//System.out.println("Customer " + clientHashMapEntrySet.getKey() + " has spent " + sum +" dollars at Mini Cafe today. ");
								}
								
								System.out.println("Customer " + clientHashMapEntrySet.getKey() + " has spent " + sum +" dollars at Mini Cafe today. ");sum++;
							}
							continue main;

						}else {
							System.out.println("There is no client yet. ");
							continue main;
						}
					}
					
				} else if (userString.equals("2")) {
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
								clientHashMap.put(clientName, clientOrderHashMap);
								//There are two options 1. Yes--got to confirmation page
								//2 No. go to preivous menu display
								while (flagClientOrderConfirmation) {
									css.areYouDownWithYourOrderDisplay();
									userString=sc.nextLine();
									if (userString.equals("Yes")) {//confirmed your order
										//save data to orderHashMap
										//save data to userHashMap
										//clientHashMap.put(clientName, clientOrderHashMap);
										//clientHashMap.
										//int clientOrderHashMapSize = clientOrderHashMap.size();
										//int sum=0;
										Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//Set<HashMap.Entry<String,Object>> clientHashMapEntrySets = clientHashMap.entrySet();
										for (HashMap.Entry<String,Object> clientHashMapEntrySet : clientHashMap.entrySet()) {
											if (clientHashMapEntrySet.getKey().equals(clientName)) {
												System.out.print(clientName);
												for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
													System.out.println(
															" has ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
													sum = sum + clientOrderEntrySet.getValue()*menuHashMap.get("burges");
												}
											}
										}

										System.out.println("You total are " + sum + " dollars" );
										System.out.println("Your sum of buerges is " + sum);
										continue main;
										//return to the main display
										//css.mainDisplay();
										//userString=sc.nextLine();

										//flagClientOrderConfirmation=false;
										//flagMenu=false;
										//flagMain=true;/

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
								//|| userString.equals("2") || userString.equals("3") ||userString.equals("4")){
								System.out.println("How many fries that you want to order: ");
								userString=sc.nextLine();
								clientOrderQuantity= Integer.parseInt(userString);
								clientOrderHashMap.put("fries", clientOrderQuantity);
								System.out.println("You have just ordered " + clientOrderHashMap.get("fries") + " fries.");
								clientHashMap.put(clientName, clientOrderHashMap);
								
								//css.clientConfirmationDisplay()
								//There are two options 1. Yes--got to confirmation page
								//2 No. go to preivous menu display
								while (flagClientOrderConfirmation) {
									css.areYouDownWithYourOrderDisplay();
									userString=sc.nextLine();
									if (userString.equals("Yes")) {//confirmed your order
										//save data to orderHashMap
										//save data to userHashMap
										//clientHashMap.put(clientName, clientOrderHashMap);
										//clientHashMap.
										//int clientOrderHashMapSize = clientOrderHashMap.size();
										Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//int sum=0;
										//Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//Set<HashMap.Entry<String,Object>> clientHashMapEntrySets = clientHashMap.entrySet();
										for (HashMap.Entry<String,Object> clientHashMapEntrySet : clientHashMap.entrySet()) {
											if (clientHashMapEntrySet.getKey().equals(clientName)) {
												System.out.print(clientName);
												for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
													System.out.println(
															" has ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
													sum = sum + clientOrderEntrySet.getValue()*menuHashMap.get("fries");
												}
											}
										}

										System.out.println("You total are " + sum + " dollars" );
										continue main;
										//return to the main display
										//css.mainDisplay();
										//userString=sc.nextLine();

										//flagClientOrderConfirmation=false;
										//flagMenu=false;
										//flagMain=true;/

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

							}else if (userString.equals("3")) {
								//|| userString.equals("2") || userString.equals("3") ||userString.equals("4")){
								System.out.println("How many cup of orange juice that you want to order: ");
								userString=sc.nextLine();
								clientOrderQuantity= Integer.parseInt(userString);
								clientOrderHashMap.put("orange juice", clientOrderQuantity);
								System.out.println("You have just ordered " + clientOrderHashMap.get("orange juice") + " orange juice.");
								//css.clientConfirmationDisplay()
								clientHashMap.put(clientName, clientOrderHashMap);
								//There are two options 1. Yes--got to confirmation page
								//2 No. go to preivous menu display
								while (flagClientOrderConfirmation) {
									css.areYouDownWithYourOrderDisplay();
									userString=sc.nextLine();
									if (userString.equals("Yes")) {//confirmed your order
										//save data to orderHashMap
										//save data to userHashMap
										//clientHashMap.put(clientName, clientOrderHashMap);
										//clientHashMap.
										//int clientOrderHashMapSize = clientOrderHashMap.size();
										Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//int sum=0;
										//Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//Set<HashMap.Entry<String,Object>> clientHashMapEntrySets = clientHashMap.entrySet();
										for (HashMap.Entry<String,Object> clientHashMapEntrySet : clientHashMap.entrySet()) {
											if (clientHashMapEntrySet.getKey().equals(clientName)) {
												System.out.print(clientName);
												for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
													System.out.println(
															" has ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
													sum = sum + clientOrderEntrySet.getValue()*menuHashMap.get("orange juice");
												}
											}
										}

										System.out.println("You total are " + sum + " dollars" );
										continue main;
										//return to the main display
										//css.mainDisplay();
										//userString=sc.nextLine();

										//flagClientOrderConfirmation=false;
										//flagMenu=false;
										//flagMain=true;/

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
							}else if (userString.equals("4")) {
								//|| userString.equals("2") || userString.equals("3") ||userString.equals("4")){
								System.out.println("How many cup of tea that you want to order: ");
								userString=sc.nextLine();
								clientOrderQuantity= Integer.parseInt(userString);
								clientOrderHashMap.put("tea", clientOrderQuantity);
								System.out.println("You have just ordered " + clientOrderHashMap.get("tea") + " teas.");
								//css.clientConfirmationDisplay()
								clientHashMap.put(clientName, clientOrderHashMap);
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
										//int sum=0;
										//Set<HashMap.Entry<String,Integer>> clientOrderEntrySets = clientOrderHashMap.entrySet();
										//Set<HashMap.Entry<String,Object>> clientHashMapEntrySets = clientHashMap.entrySet();
										for (HashMap.Entry<String,Object> clientHashMapEntrySet : clientHashMap.entrySet()) {
											if (clientHashMapEntrySet.getKey().equals(clientName)) {
												System.out.print(clientName);
												for (HashMap.Entry<String,Integer> clientOrderEntrySet : clientOrderEntrySets) {
													System.out.println(
															" has ordered "+ clientOrderEntrySet.getValue() + " " + clientOrderEntrySet.getKey());
													sum = sum + clientOrderEntrySet.getValue()*menuHashMap.get("tea");
												}
											}
										}

										System.out.println("You total are " + sum + " dollars" );
										continue main;
										//return to the main display
										//css.mainDisplay();
										//userString=sc.nextLine();

										//flagClientOrderConfirmation=false;
										//flagMenu=false;
										//flagMain=true;/

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
							}else {
								continue menu;
								//System.out.println("Hi, I am here");
								//css.menuDisplay();
								//css.mainDisplay();
								//userString=sc.nextLine();					
							}
						}
				} else if (userString.equals("3")) {
					break;
				} else continue main;
			}
		sc.close();
		System.out.println("Thank you for visiting Mini Cafe. See you next time!");
	}

}

