package com.revature;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public class MainDriver {
	
	public static void main(String[] args) {
		
		/*
		 * Arrays: a collection of elements of the same datatype. The size is immutable
		 * 
		 * There are limitations, 
		 * 	not many methods
		 * 	mainly the size is unchangeble
		 * 
		 *
		 */
		
		String[] array = new String[3];
		
		
		/*
		 * Collection framework (more akin to a library). Provides interfaces and classes that allow
		 * 	developers to more easily manage groups of objects. 
		 * 
		 * A "collection" object is designed to store objects. DOES NOT STORE PRIMITIVES.
		 * 
		 * Set (interface):
		 * 		Do not allow duplicates 
		 * 		Do not guarantee insertion order. 
		 * 		(Only inherits methods from the Collection + restriction to duplicate)
		 * 		Sets are equal if they contain the same elements. 
		 * 
		 * 		Classes:
		 * 			HashSet: Maintains no order, stores in hash table, best performance
		 * 			LinkedHashSet: maintains insertion order, weaker performance
		 * 			TreeSet: Maintains value order, red-black tree, very slow
		 * 
		 * 		HashSet vs TreeSet:
		 * 			TreeSets have to have homogenous objects and cannot contain null values.
		 * 			HashSet can store hetrogenous objects and null values. 
		 * 
		 * List (interface) :
		 * 		An ordered collection.
		 * 		May contain duplicate elements.
		 * 		Access via index (positional access)
		 * 		Lists have to contain the same elements in the same position to be equal
		 * 
		 * 		Classes:
		 * 			ArrayList:
		 * 				A resizable array (mutable) compared to the the built in array. Allows you to 
		 * 				add and remove elements in it.
		 * 			LinkedList:
		 * 				Consists of nodes, each node will store a value and a 'pointer' to the next node.
		 * 			Vector
		 * 				Deprecated (contains legacy methods), but is sychronised
		 * 
		 * Queue
		 * 		Ordered list of objects related to insertion order
		 * 		Follows FIFO (First-in-First-out) principle
		 * 
		 * 		Classes:
		 * 			LinkedList: Maintains insertion order
		 * 
		 * 			PriorityQueue: 
		 * 				Doesn't permit null 
		 * 				Can't store hetrogenous objects
		 * 				Maintains value order, not insertion
		 * 
		 * Stack 
		 * 		Ordered list of objects related to insertion order. 
		 * 		Follows FILO (First in last out) or LIFO (last in first out)
		 * 
		 */
		
		
		// LIST STUFF 
		List<String> listString = new ArrayList<>(); // we didn't specify size 
		
		listString.add("First String");
		listString.add("Adding more arguments");
		
		List<String> anotherList = new LinkedList<>();
		
		ArrayList<String> alist = new ArrayList<>();

		
		anotherList.add("First String");
		anotherList.add("Adding more arguments");
		
//		System.out.println(array);
//		System.out.println(anotherList.get(0));
		
		
		
		//SET STUFF
		
		Set<Object> mySet = new HashSet<>();
		
		mySet.add("First String");
		mySet.add("Planet");
//		System.out.println(mySet.add("First String"));
		
		/*
		 * 
		 * Set of all users 
		 * 
		 * I don't want users to create multiple accounts 
		 * 
		 * User fakeUser = new User();
		 * 
		 * if(listOfUser.add(fakeUser){
		 * 		syso("Well done, your now a user");
		 * } else{
		 * 	syso(user already exists)
		 * }
		 * 
		 */
		
//		System.out.println(mySet.contains("Planet"));
//		System.out.println(mySet.remove("Planet"));
		
		
//		System.out.println(mySet.remove("Planet"));
		
//		System.out.println(mySet);
		
		//Queue
		//poll, remove, peek and element
		
		Queue<String> myQ = new LinkedList<>();
		
		
		myQ.add("a");
		myQ.add("b");
		myQ.add("c");
		myQ.add("d");
		
		
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ.poll());
		System.out.println(myQ);
		
		
		
		/*
		 * Wrapper classes
		 * 
		 * int -> Integer
		 * double -> Double 
		 * float -> Float
		 * short -> Short
		 * boolean -> Boolean
		 * long -> Long
		 * byte -> Byte
		 * char -> Character
		 */
		
//		Integer a = 1;
	
		String s = "1";
		
		Integer i = Integer.parseInt(s);
		
		
		System.out.println(i);
	
		
		
		
	}

}
