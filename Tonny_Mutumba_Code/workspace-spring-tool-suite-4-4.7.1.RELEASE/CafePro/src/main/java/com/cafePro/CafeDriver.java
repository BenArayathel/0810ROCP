package com.cafePro;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class CafeDriver {
	
	private String name;
	private Integer order;

	public CafeDriver(String name, Integer order) {
		this.name = name;
		this.order = order;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getOrder() {
		return order;
	}
	
	public void setOrder(Integer order) {
		this.order = order;
	}
	
	public String toString() {
		return String.format(name, order);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Double> drinks = new HashMap<String, Double>(); 
		
		drinks.put("Black Coffee ", 4.00);
		drinks.put("Espresso ",  4.00);
		drinks.put("tea ",  4.00);
		drinks.put("Milk ",  4.00);
		drinks.put("Ice Tea ",  4.00);
		drinks.put("soft drinks ", 2.00);
		
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
		food.put("Cheess Sandwich ",  4.00);
		food.put("Bacon Sandwich ",  4.00);
		food.put("Tuna Sandwich ", 4.00);
		
		//System.out.println("This is the Sandwich menu: " + food);
		for (Entry<String, Double> entry : food.entrySet()) {
            String k = entry.getKey();
            Double v = entry.getValue();
            System.out.println( k + "- $" + v);
        }
		
		
	}

}
