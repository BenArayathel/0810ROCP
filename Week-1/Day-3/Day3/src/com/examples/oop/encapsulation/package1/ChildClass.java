package com.examples.oop.encapsulation.package1;

import com.examples.oop.encapsulation.package2.DemoObject;

public class ChildClass extends DemoObject{
	
	
	public void myMethod() {
		String s = super.getSecret();
	}
}
