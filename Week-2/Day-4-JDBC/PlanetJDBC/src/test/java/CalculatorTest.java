import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.util.UnitTestCalculator;

public class CalculatorTest {
	
	@Test
	public void testAdd() {
		
		assertEquals(10, UnitTestCalculator.add(3, 7));
	}
	
	
	@Test
	public void testMultiply() {
		assertEquals(10, UnitTestCalculator.multiply(2,5),0.00001);
	}
	
	@Test
	public void testDivide() {
		assertEquals(1, UnitTestCalculator.divide(10, 10),0.1);
	}

}
