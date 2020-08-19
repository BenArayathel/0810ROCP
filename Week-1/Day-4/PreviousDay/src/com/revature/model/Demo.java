package com.revature.model;

final public class Demo {
	
	private final String name;
	
	public Demo(String name) {
		this.name = name;
	}
	
	public Demo() {
		this.name = "immutable name";
	}
	
	

	//Public Getters and Setters
	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return "Demo [name=" + name + "]";
	}
	
	
	
	
	
	

}
