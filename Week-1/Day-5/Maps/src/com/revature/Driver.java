package com.revature;

import java.util.HashMap;
import java.util.Map;

import com.revature.models.Planet;
import com.revature.models.Rocket;

public class Driver {
	
	/*
	 * Is an object that maps 'keys' to 'values' (also known as a dictionary in other languages). Each key has to be unique and can be mapped to only 
	one value, note that a key can be mapped to duplicate values. 

	Methods for basic operations:
		put, get, remove, containsKey, contiansValue, size and empty
	Bulk Operations:
		putAll, clear 
	Collection Views:
		keySet, entrySet and values.

	Classes:
		HashMap: (Uses a technique called "Hashing" to map large string to short string, helps in indexing and searching)
			Allows duplicate values, not duplicate keys 
			Allows a single null key and multiple null values
			Does not guarantee order (and unsynchronized compared to HashTable)

		TreeMap:
			Does not allow null keys, but does allow null values
			Sorted according to the natural ordering of the keys

		LinkedHashMap:
			Very similar to a HashMap, but it maintains insertion order 
	
	You cannot iterate over the Map objects, like you would from the Collection interface:
		You will have to iterate over the key set (.keySet()), value set (.valueSet()) or the entry set (.entrySet()).
	
	*/
	
	public static void main(String[] args) {

		Map<String, Planet> solarSystem = new HashMap<>(); //Map is an interface, so need a child class to instantiate it
		
		Planet v = new Planet(2, "Venus");
		
		solarSystem.put("Mercury", new Planet(1,"Mercury"));
		solarSystem.put(v.getName(), v);
		solarSystem.put("Another Venus", v);
		
//		System.out.println(solarSystem.get(v.getName()));
		
		
		Map<Rocket, Planet> solarSystem2 = new HashMap<>(); //You can use any object type as key or value
		
		Rocket a = new Rocket("apollo something");
		solarSystem2.put(a, new Planet(1, "Mercury") );
		solarSystem2.put(new Rocket("another rocket"), new Planet(2, "Venus") ); // I can't access Venus, this rocket does not have a reference
																				// variable that I can pass into my get method
		
		System.out.println(solarSystem);
		System.out.println(solarSystem.get(a)); 
		
		
		
		
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
