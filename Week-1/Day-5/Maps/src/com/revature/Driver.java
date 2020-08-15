package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Planet;
import com.revature.models.Rocket;

public class Driver {
	
	/*
	 * Map or Dictionary
	 * 
	 * Is an object that maps 'keys' to 'values' (like a dictionary).
	 * Each key has to be unique and can be mapped to only one value, however that key 
	 * can be mapped to duplicate values.
	 * 
	 */

	//HashMap: Allows duplicate values, not duplicate keys
//				Allows a single null key, and multiple null values
//				Does not guarantee order 
	
	//TreeMap: sorted by value, null values
	
	//LinkedHAshMap: insertion order 
	
	public static void main(String[] args) {

		Map<String, Planet> solarSystem = new HashMap<>(); //Map is an interface
		
		Planet v = new Planet(2, "Venus");
		
		solarSystem.put("Mercury", new Planet(1,"Mercury"));
		solarSystem.put(v.getName(), v);
		solarSystem.put("Another Venus", v);
		
//		System.out.println(solarSystem.get(v.getName()));
		
		
//		Map<Rocket, Planet> solarSystem = new HashMap<>();
//		
//		Rocket a = new Rocket("apollo something");
//		solarSystem.put(a, new Planet(1, "Mercury") );
//		
//		System.out.println(solarSystem);
//		System.out.println(solarSystem.get(a));
		
		//no direct way to iterate a map object
		
//		System.out.println(solarSystem.keySet());
//		System.out.println(solarSystem.values());
		System.out.println(solarSystem.entrySet());
		
		for(String i: solarSystem.keySet()) {
			System.out.println(i);
		}
//		

	}

}
