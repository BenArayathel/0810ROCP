package com.examples;

public class ArrayExample {
public static void main(String[] args) {
	int[] intArray=new int[5];
	char[] charArray= {'a','b','c','d'};
	
	for (int i=0;i<charArray.length;i++) {
		System.out.println(charArray[i]);
	}


for(char i:charArray) {
	System.out.println(i);
}
}
}
