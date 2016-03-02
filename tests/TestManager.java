import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Joss Steward
 */
public class TestManager {
	/**
	 * Test converting an integer string into an integer.
	 */
	@Test
	public void testIntegerConversion() {
		Manager manager = new Manager();
		assertEquals(200.0f, manager.ConvertToDecimal("200"), 0.0001);
	}
	
	/**
	 * Test converting a decimal.
	 */
	@Test
	public void testDecimalConversion() {
		Manager manager = new Manager();
		assertEquals(200.05, manager.ConvertToDecimal("200.05"), 0.0001);
	}
	
	/**
	 * Test converting a negative integer string into an integer.
	 */
	@Test
	public void testNegativeConversion() {
		Manager manager = new Manager();
		assertEquals(-200.0f, manager.ConvertToDecimal("-200"), 0.0001);
	}

	/**
	 * Test converting an integer string with a leading '+' into an integer.
	 */
	@Test
	public void testLeadingPlusConversion() {
		Manager manager = new Manager();
		assertEquals(200.0f, manager.ConvertToDecimal("+200"), 0.0001);
	}
	
	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion() {
		Manager manager = new Manager();
		assertEquals(0, manager.ConvertToDecimal("200.05.0004"), 0.0001);
	}
	
	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion2() {
		Manager manager = new Manager();
		assertEquals(0, manager.ConvertToDecimal("abc123"), 0.0001);
	}

	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion3() {
		Manager manager = new Manager();
		assertEquals(0, manager.ConvertToDecimal("123abc"), 0.0001);
	}

	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion4() {
		Manager manager = new Manager();
		assertEquals(0, manager.ConvertToDecimal(" 123"), 0.0001);
	}
}
