package com.example.package3;

public class POJO {
	
	private String name;
	
	public POJO() {
		super();
		this.name ="Bob";
	}
	
	public POJO(String name) {
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return "POJO [name=" + name + "]";
	}
	
	

}
