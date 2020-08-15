package com.revature.comparator;

import java.util.Comparator;

import com.revature.model.Student;

public class StudentComparator implements Comparator<Student>{
	
	/*
	 * Comparator interface is external to the class being compared to 
	 * 
	 * It is utilised by the Collection.sort() method, in particular, it will use the compare method present
	 */

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getName().compareTo(s2.getName());
		
		
		
		
	
	}

	

	

}
