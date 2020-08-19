package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.customException.RocketFailuer;

public class Driver {
	
	/*
	 * An exception is a problem that arises during the exception of a program. If an exception occurs, the normal flow of the program (hopefully)
	 * has been messed up. 
	 * 
	 * Everything in Java is an object (except primitives), so.... Exceptions are objects as well with their own hierarchy. 
	 * 
	 * Exceptions are caused (typically) by poor coding practices
	 * 
	 * Errors are far more serious, they are typically issues at the hardware/system level that can't be resolved by code.
	 * 
	 * 
	 */
	
	
	
	/*
	 *EXCEPTION CLASS HIERARCHY 

		At the top of the hierarchy is throwable, this is weird because it's also a class
		(most other hierarchy, like Collection framework have a root interface)
	

						-> Error (class)
		Throwable (class)-> 
						-> Exception (class) -> Runtime Exception (class)

	Compile time exceptions occur during runtime (suprise),
	but your IDE will still force you to implement a method of catching these
	errors. (These are called checked exception because you are forced to check for them)
	Examples:
		IOException, SQLException, etc...

	Run time exceptions don't need to be explicitly handled, they 
	are distinguished by the fact that the exception might not 
	by likely to happen so the IDE will let you get away with 	
	leaving it alone.  (These are called unchecked exception because they can go unchecked)
	Examples:
		NullPointerException, IndexOutOfBoundsException, etc...
	 * 
	 * 
	 */
	
	/*
	 * HOW TO HANDLE EXCEPTION? 
	 * 
	 * 
	 * THROWS : 
	 * 		This passes the responsibility of handling the risky code to the method that invokes the method. 
	 * 
	 * TRY: 
	 * 		Try is used to handle risky code. They have to consist of at least 2 parts.
	 * 
	 * 		try {
	 * 
	 * 		//RISKY CODE
	 * 		
	 * 		} catch (Exception e) {
	 * 
	 * 		//HANDLE EXCEPTION, if it is thrown 
	 * 		//only executes if code throws exception 
	 * 
	 * 		} finally {
	 * 		
	 * 		//EXCECUTES CODE, regardless of whether an exception is thrown or not 
	 * 
	 * 		}
	 * 
	 * 		You can have:
	 * 			Try, Catch and Finally 
	 * 			Try and Finally 
	 * 			Try and Catch 
	 * 		
	 * CAN I HANDLE ERRORS or THROWABLE? 
	 * 		Yes.
	 * 
	 * SHOULD I HANDLE THROWABLE or ERROR?
	 * 		I shouldn't handle error because it's caused by something that code cannot resolve. 
	 * 		
	 * 
	 */
	
	/*
	 * THROW will throw an exception (get it? because exception is throwable) 
	 * 
	 * NOTE:
	 * 		throw vs throws?
	 * 
	 * 		final vs finally vs finalize() ? 
	 * 
	 */
	
	
	
	public static void anotherMethod() throws Exception{ // keep passing the responsibilty
		myMethod();
	}
	
	public static void myMethod() throws Exception { //passes the responsibilty to whoever invokes it. (line 111)
		
		throw new Exception();
		
	}
	
	public static void main(String[] args) throws Exception {		
		
	try {
		anotherMethod();
	} catch (Exception e) {

//		e.printStackTrace(); // .printStackTrace() will output the nature of the exception and where the exception was. 
							 // useful for debugging code.
		
		
		System.out.println("An exception was thrown, try again"); //If an exception is thrown, makes sure it explains what the user problem was
																	// and how to resolve it. 
	} finally {
		
		// no matter what, this will print "Hello"
		System.out.println("Hello");
		// except for if your computer gets struck by lightening. 
	}
	
	
	}
}
