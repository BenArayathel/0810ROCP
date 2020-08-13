package com.examples.string;

public class BuilderAndBuffer {
	
	/*
	 * StringBuilder vs StringBuffer 
	 * 
	 * Both are MUTABLE
	 * 
	 * Stringbuilder is more efficient than StringBuffer, is not thread-safe
	 * StringBuffer is slower, but thread-safe/synchronized
	 * 
	 */
	
	public static void main(String[] args) {
		
		String s = "Hi";
		s = s.concat("There");
		System.out.println(s);
		
		StringBuilder sb = new StringBuilder("Hello there");
		sb.append(" from the other side");
		
		StringBuffer sbuf = new StringBuffer("Hello");
		sbuf.append(" World");
		
		System.out.println(sbuf);
		
	}
	
	
	
	/*
	 * Threads: an isolated logic that is executed
	 * 
	 * 10 tasks 
	 * 
	 * 											1st Thread : 1 -> 1-> sb = "kiwi"; -> 1-> 1 (stack)
	 * 1 -> 1->	Stringbuffer sb = "apples"															 -> 
	 * 											2nd Thread : 1 -> 1-> sb = "banana" -> 1-> 1 (stack)
	*/

}
