package com.example.string;

public class BuilderAndBuffer {

	/*
	 * Both are mutable, cause String is immutable
	 * 
	 * 
	 * stringbuilder is more efficient
	 * stringbuffer is thread-safe/ synchronized
	 */
	
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("Hello there");
		sb.append(" from the other side");
		
		StringBuffer sbuf = new StringBuffer("Hello ");
		sbuf.append("world");
		System.out.println(sbuf);
	}
}
