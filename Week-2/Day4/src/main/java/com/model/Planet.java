package com.model;

public class Planet {
	private int id;
	private String name;
	private String description;
	private boolean rings;
	private int numberOfMoons;
	
	public Planet() {
		super();
	}
	
	public Planet(int id, String name, String description, boolean rings, int numberOfMoons) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.rings = rings;
		this.numberOfMoons = numberOfMoons;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isRings() {
		return rings;
	}
	public void setRings(boolean rings) {
		this.rings = rings;
	}
	public int getNumberOfMoons() {
		return numberOfMoons;
	}
	public void setNumberOfMoons(int numberOfMoons) {
		this.numberOfMoons = numberOfMoons;
	}
	@Override
	public String toString() {
		return "Planet [id=" + id + ", name=" + name + ", description=" + description + ", rings=" + rings
				+ ", numberOfMoons=" + numberOfMoons + "]";
	}
	
}
