package com.kash.models;

import java.util.HashSet;
import java.util.Set;

public class Item {
	
	static Set<Item> items = new HashSet<Item>();
	
	//private int id;
	private String name;
	
	//private static int auto_inc = 1;
	
	public static Item getItem(String s) {
		for(Item r: items) {
			if (r.getName().equals(s)) {
				return r;
			}
		}
		//System.out.println(rooms);
		//System.out.println("bone");
		return null;
	}
	
	public Item(String n) {
//		this.id = auto_inc;
//		this.auto_inc += 1;
		this.name = n;
		items.add(this);
	}
	
//	public Item(int i, String n) {
//		//this.id = i;
//		this.name = n;
//		
//	}
	
//	public int getID() {
//		return this.id;
//	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
