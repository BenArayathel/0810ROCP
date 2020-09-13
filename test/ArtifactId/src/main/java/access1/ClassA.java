package access1;

import access2.ClassC;

public class ClassA {
	
	private int i = 1;
	private String s = "Hello World!";
	ClassA a = new ClassA();
	

	public static void main (String[] args) {
		System.out.println("hi");
		System.out.println(a.getName());
	}
	public static String getName() {
		return s;
	}
	
}
