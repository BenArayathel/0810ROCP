package com.revature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.revature.comparator.StudentComparator;
import com.revature.model.Student;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//GENERICS - ensures type safety
		// "Allow a type or method to operate on object while providing compile-time type safety". introduced in Java 5.0
		
		ArrayList<Student> sList = new ArrayList<Student>();
		
		sList.add(new Student(1,"z"));
		sList.add(new Student(4,"b"));
		sList.add(new Student(5,"a"));
		sList.add(new Student(7,"a"));
		sList.add(new Student(2,"d"));
		sList.add(new Student(3,"c"));
		sList.add(new Student(3,"c"));
		sList.add(new Student(3,"c"));
		sList.add(new Student());
		
//		Collections.sort(sList);
//		Collections.sort
		Collections.sort(sList, new StudentComparator());
		
		
		System.out.println(sList);

	}

}
