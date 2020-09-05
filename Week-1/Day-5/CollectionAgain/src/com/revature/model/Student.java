package com.revature.model;

public class Student implements Comparable<Student>{ 
	
	/*
	 * Implementing Comparable means that we provide our class a way to compare with each instance of the class. 
	 * 
	 * This allows the Collections.sort() method to order our List by using the compareTo() method.
	 */
	
	private int id;
	private String name;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	@Override
	public int compareTo(Student s) { //This is the method that comparable asks us to implement
		
		int value = 0;
	
		return -(this.id - s.id); // -1000 or -1, 0 , +1000 or +1
								//It does not care what the magnitude is, just if it is positive, 0 or negative. 
	}
	
	
	
	

}
