package com.example.garbage;

import com.example.model.DemoObject;

public class GarbageCollection {
	
	public static void objectRemoval() {
		DemoObject reference = new DemoObject();
	}
	
	
	/*
	 * Garbage Collection is the reason why we as programmers don't need to worry 
	 * about memory allocation. Negligent coding this regard, leads to OutOfMemoryErrors.
	 * 
	 * GC is a daemon thread. Always running in the background. It's purpose is to clear
	 * the heap memory to free up space for other objects.
	 * 
	 * It removes objects that are eligible for removal, what does it take for it to 
	 * be eligible? 
	 * 
	 *  UNREACHABLE OBJECTS, e.g. all and any references to the obejct has been removed.
	 *  
	 *  
	 */
	
	public static void main(String[] args) throws Throwable {
		
		
		DemoObject reference = new DemoObject(); // 2nd gc
		DemoObject r2 = new DemoObject(); //1st gc
		DemoObject r3 = new DemoObject(); //
		DemoObject r4 = new DemoObject(); //
		
		r2 = r3;
		r2 = r4;		
		reference = null; //nullify the reference
		
		reference = new DemoObject(); //reassign the reference
		
		//creating an object within a memory
		objectRemoval();
		
		
		System.gc();
		
		/*
		 * Finalize() method:
		 * 	Is a method (contained within the object class) that is called just before
		 * 	an object is reclaimed for destruction. Allows you to execute some code 
		 * 	just before the object is destroyed
		 * 
		 */
		
		
		
		DemoObject myRef1 = new DemoObject(1,"a string");
		DemoObject myRef2 = new DemoObject(2,"a string");
		DemoObject myRef3 = new DemoObject(3,"a string");
		DemoObject myRef4 = new DemoObject(4,"a string");
		
		/*
		 * o1 -> O
		 * o2 -> O
		 * o3 -> O
		 * o4 -> O
		 */
		myRef4 = myRef1; //Garbage collector, it comes and removes stuff from memory
		/*
		 * 	     O
		 * o2 -> O
		 * o3 -> O
		 * o4 & o1 -> O
		 */
		myRef1 = null;
		/*
		 * o1 	 O
		 * o2 -> O
		 * o3 -> O
		 * o4 -> O
		 */
		
		System.out.println(myRef4.b);
		
		
		
	}
	

}
