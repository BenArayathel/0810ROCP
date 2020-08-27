<<<<<<< HEAD
package main.java.com.revature.models;

public class Planet {

	public Planet(String string) {
		// TODO Auto-generated constructor stub
	}

	
=======
package com.revature.models;

public class Planet {
	
	private String name;
	

	public Planet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + "]";
	}
	
	

>>>>>>> 6bb79a10fcb3e78822c11a0c9ba3e0884ef93279
}
