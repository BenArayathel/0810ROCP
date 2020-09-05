package com.revature.models;

public class User {
	
	private Car ourCar;

	public Car getOurCar() {
		return ourCar;
	}

	public void setOurCar(Car ourCar) {
		this.ourCar = ourCar;
	}

	public User(Car ourCar) {
		super();
		this.ourCar = ourCar;
	}

	@Override
	public String toString() {
		return "User [ourCar=" + ourCar + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
