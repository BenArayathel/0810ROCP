package com.revature.models;

public class Rocket {
	
	private String name;

	public Rocket(String name) {
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
		return "Rocket [name=" + name + "]";
	}
	
	

}
