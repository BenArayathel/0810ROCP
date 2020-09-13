package com.revature.testing;

import com.revature.realclass.Add;

public class TestAdd {
	@Test
	public static void testAddNumbers() {
		assertEquals(10, new Add.addNumbers(3,7));
	}
	
	

}
