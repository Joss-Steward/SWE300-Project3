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
		assertEquals(200.0f, Manager.ConvertToDecimal("200"), 0.0001);
	}
	
	/**
	 * Test converting a decimal.
	 */
	@Test
	public void testDecimalConversion() {
		assertEquals(200.05, Manager.ConvertToDecimal("200.05"), 0.0001);
	}
	
	/**
	 * Test converting a negative integer string into an integer.
	 */
	@Test
	public void testNegativeConversion() {
		assertEquals(-200.0f, Manager.ConvertToDecimal("-200"), 0.0001);
	}

	/**
	 * Test converting an integer string with a leading '+' into an integer.
	 */
	@Test
	public void testLeadingPlusConversion() {
		assertEquals(200.0f, Manager.ConvertToDecimal("+200"), 0.0001);
	}
	
	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion() {
		assertEquals(0, Manager.ConvertToDecimal("200.05.0004"), 0.0001);
	}
	
	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion2() {
		assertEquals(0, Manager.ConvertToDecimal("abc123"), 0.0001);
	}

	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion3() {
		assertEquals(0, Manager.ConvertToDecimal("123abc"), 0.0001);
	}

	/**
	 * Test an invalid conversion.
	 */
	@Test
	public void testInvalidConversion4() {
		assertEquals(0, Manager.ConvertToDecimal(" 123"), 0.0001);
	}
}
