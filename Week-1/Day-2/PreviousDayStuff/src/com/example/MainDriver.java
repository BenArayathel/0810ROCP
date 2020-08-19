package com.example;

import com.example.models.*;

public class MainDriver {
	
	int myint;
	
	public boolean isFull() {
		return true;
	}
	
//	public boolean isItReallyFull() {
//		TeaCup tp = new TeaCup();
//		
//		return tp.isFull();
//	}
	
	
	public static void main(String[] apples) {
		
		MainDriver md = new MainDriver();
		System.out.println(md.isFull());
		TeaCup t;
		
		TeaCup[] arrayOfTeaCups = new TeaCup[3];
		TeaCup[] moreTea = {new TeaCup()};
		
		moreTea[0].storeTea();
		
		String fruit = "Apples";
		
		switch(moreTea[0].getName()) {
		case "Kiwi":
			System.out.println("It's a kiwi");
			break;
		case "2":
			System.out.println("It's a 2");
			
		}
		
		for(int i =0; i < 4; i++) {
			
			if(i == 1) {
				break;
			}
			System.out.println(i);
		}
		
	}

}
