package com.examples.oop.encapsulation.package2;

public class Pojo {
 // Plain Old Java Object
	// user 
	
	private String secret; //private variables
	
	

	public Pojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Pojo(String secret,String passcode) {
		super();
		this.secret = secret;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	@Override
	public String toString() {
		return "Pojo [secret=" + secret + "]";
	}
	
	
	
}
