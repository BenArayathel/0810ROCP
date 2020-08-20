package com.cafe;

//import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//import java.util.Scanner;
//import java.awt.*;

public class UserClass {
	String clientName;
	//int mainCourseQuantity;
	Map<String,Integer> mainCourseHashMap = new HashMap<String,Integer>();
	Map<String,Integer> drinkHashMap = new HashMap<String,Integer>();
	
	public void setClientName(String s) {
		this.clientName = s;
	}
	
	public String getClientName() {
		return this.clientName;
	}
		
	public void setMainCourse(String mainCourseName, int mainCourseQuantity) {
		this.mainCourseHashMap.put(mainCourseName, mainCourseQuantity);
		 
	}
	
	public void setDrink(String drinkName, int drinkQuantity) {
		this.drinkHashMap.put(drinkName, drinkQuantity);
	}
}
