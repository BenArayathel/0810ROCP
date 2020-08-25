package com.revature;

import com.revature.model.*;

public class MainDriver {
	
	public static void main(String[] args) {
		
		Demo demo = new Demo("Demo");
		
		demo = new Demo();
		
//		demo.setName("I'm changing");
		
		System.out.println(demo.getName());
		
	}

}
