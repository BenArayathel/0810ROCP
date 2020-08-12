package com.examples;

public class switchExample {
//copampare variable to expression for a match and execute the code inside
	public static void main(String[] args) {
		char myChar ='d';
		switch(myChar) {
		case 'a':
			System.out.println("a");
			break;
		case 'd':
			System.out.println("d");
			break;
		default:
			System.out.println("default");
			break;
	}
	}
}
