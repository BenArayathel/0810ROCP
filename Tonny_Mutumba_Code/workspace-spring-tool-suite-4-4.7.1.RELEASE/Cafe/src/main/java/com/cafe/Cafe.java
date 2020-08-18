package com.cafe;

import java.util.*;
import java.util.Map.Entry;

public class Cafe {
	static String choice;
	static String refresh;
	static String name;
	String menu;
	
	static void getName() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("What's your name please? ");
		name = s.nextLine();
	}
	
	public static void getMenu() {
		Map<String, Double> drinks = new HashMap<String, Double>(); 
		
		drinks.put("Black Coffee ", 2.00);
		drinks.put("Espresso ",  3.00);
		drinks.put("tea ",  2.00);
		drinks.put("Milk ",  2.00);
		drinks.put("Ice Tea ",  2.00);
		drinks.put("soft drink ", 2.00);
		
		//System.out.println("This is the drinks: " + drinks);
		for (Entry<String, Double> entry : drinks.entrySet()) {
            String k = entry.getKey();
            Double v = entry.getValue();
            System.out.println( k + "- $" + v);
        }
		
		System.out.println('\n');
		
		
		Map<String, Double> food = new HashMap<String, Double>();
		
		food.put("Chicken Sandwich ", 4.00);
		food.put("Burger ",  4.00);
		food.put("Burrito ",  4.00);
		food.put("Cheese Sandwich ",  4.00);
		food.put("Bacon Sandwich ",  4.00);
		food.put("Tuna Sandwich ", 4.00);
		
		//System.out.println("This is the Sandwich menu: " + food);
		for (Entry<String, Double> entry : food.entrySet()) {
            String k = entry.getKey();
            Double v = entry.getValue();
            System.out.println( k + "- $" + v);
        }
		
//		HashMap<String, Integer> entries = new HashMap<String, Integer>(food);
//		for (Entry<String, Double> choice : food.entrySet()) {
//			System.out.println(choice.getKey());	
//		}
	}
	
	static void getOrder(String choice, String refresh ) {
		
		
		System.out.println("What can i get you please? ");
		System.out.println("Show menu: \n");
		getMenu();	
		
		Scanner c = new Scanner(System.in);
		choice = c.nextLine();
		choice = choice.replaceAll("\\p{Punct}|\\s", "");
		refresh = c.nextLine();
		System.out.println(name + " your Ordered " + choice + " and " + refresh );
	
	}
	
	public Cafe( ) {
		
	}
	
	
	public static void main(String[] args) {
		
		Cafe.getName();
		Cafe.getOrder(choice, refresh);
	}

}
