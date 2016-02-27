import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Drew Rife and Brad Olah
 *
 * Tests the functionality of Decimal State
 */
public class testDecimalState {

	/**
	 * Tests initialization of 
	 * sign, value, and point
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testInitialization() {
		State testState = new DecimalState(1, 0, .1);
		assertEquals(1, testState.getSign());
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(0.1f, testState.getPoint(), 0.0001);
	}

	/**
	 * tests an integer input
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testIntegerInput() {
		State testState = new DecimalState(1, 5, .1);
		State nextState = testState.evaluate('2');
		assertTrue(nextState instanceof DecimalState);
		assertEquals(5.2, nextState.getValue(), 0.0001);
		assertEquals(0.01, nextState.getPoint(), 0.0001);
	}
	
	/**
	 * tests for null terminator
	 * @author Drew Rife and Brad Olah
	 */
	public void testNullTerminator() {
		State testState = new DecimalState(-1, 5, .1);
		State nextState = testState.evaluate('\0');
		assertTrue(nextState instanceof EndState);
		assertEquals(-5, nextState.getValue(), 0.0001);
	}
	
	/**
	 * tests for invalid input
	 */
	public void testInvalidInput() {
		State testState = new DecimalState(-1, 5, .1);
		State nextState = testState.evaluate('~');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}
}