package com.revature.testsub;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.testings.Add;

public class TestAdd {
	@Test
	public void testAddClass() {
		assertEquals(10, Add.addNumbers(3, 7));
	}
}
