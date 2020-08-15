package com.revature.comparator;

import java.util.Comparator;

import com.revature.model.Student;

public class StudentComparator implements Comparator<Student>{

	@Override
	public int compare(Student s1, Student s2) {
		
		return s1.getName().compareTo(s2.getName());
		
		
		
		
	
	}

	

	

}
