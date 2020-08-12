package com.examples;

public class WhileExample {

	public static void main(String[] args)
	{
		int i=1;
		while(i<100) {
			
			if (i==50) {
				continue;
			} else {
			System.out.println(i);
			}
			i++;
		}
	}
}
