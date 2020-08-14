package com.example;

public class room {
	private String name;
	private String[] items;
	

	String getName() {
	return name;
}
	
	public void setName(String name) {
	this.name = name;
}
	
	public String getItems() {
	     String str="";
		for(int i=0;i<=items.length-1;i++) {
			str=str+" "+this.items[i];
		}
			return str;
		}
		 
	public void setItems(String[] items) {
	this.items = items;
}

	public room(String name, String greeting, String[] items) {
		super();
		this.name = name;
		this.items = items;
		
	}

}
