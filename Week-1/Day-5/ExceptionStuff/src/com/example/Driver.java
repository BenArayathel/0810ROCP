package com.example;

import java.sql.SQLException;
import java.util.Scanner;

import com.example.customException.RocketFailuer;

public class Driver {
	
	/*
	 * Exceptions are a way of giving feedback for poor coding.
	 * 
	 * Everything in Java is an object (except primitives)
	 * 
	 * Exceptions are classes. 
	 * 
	 * Exceptions are caused (typically) by poor coding practices
	 * 
	 * Errors are far more serious, they are issues at the hardware/system level.
	 * 
	 * Exception vs RuntimeException. 
	 * 
	 * Exceptions is that, java will force you to handle it straigt away
	 * 	e.g. IOException, SQLException, ...
	 * 
	 * Runtime exception don't need to be handled explicitly 
	 * 
	 * 
	 * THROW vs THROWS vs try and catch blocks 
	 * 
	 * 
	 */
	
	public static void anotherrMethod() {
		myMethod();
	}
	
	public static void myMethod() throws RuntimeException {
		
//		throw new Exception();
		
//		try {
//			throw new Exception();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	
	public static void main(String[] args) throws Exception {
		
//		myMethod();
	
		
	try {
		myMethod();
	} catch (Exception e) {
		// TODO Auto-generated catch block
//		e.printStackTrace();
		System.out.println("Anm exception was thrown, try again");
	}
	
	System.out.println("Hello");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		Scanner sc = new Scanner(System.in);
		
		/*
		 * try catch 
		 * try finally 
		 * try catch finally 
		 */
		
		
		
//		try {
//			int a = 1/0;
//		
//
//			
//		}  finally {
//			
//			//make sure this is proper 
//			System.out.println("Finally");
//			
//		}
		
//		String b = sc.nextLine();
//		int c = Integer.parseInt(b);
		
		// You put in risky logic
		
		
//		int a = 1/c;
//		
//		try {
//			
//			
//			
//			// does not execture here if line 31 does not work 
//			System.out.println("Everything is fine");
//			
//		}catch (NumberFormatException e) {
//			
//			System.out.println("Please put in a number");
//			
//		} catch( RuntimeException e) {
//			
//		}catch(Exception e){
//			
//		} 
//		
//		System.out.println("Hello There ");
//		
//		
	}

}
