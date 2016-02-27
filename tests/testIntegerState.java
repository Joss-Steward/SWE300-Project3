import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Drew Rife and Brad Olah
 * 
 * Tests the functinality of integer state
 */
public class testIntegerState {

	/**
	 * tests initialization of
	 * sign and value
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testInitialization() {
		State testState = new IntegerState(1, 5);
		assertEquals(1, testState.getSign());
		assertEquals(5, testState.getValue(), 0.0001);
	}
	
	/**
	 * tests that it stays in Integer State
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testStaysInIntegerState() {
		State testState = new IntegerState(-1, 5);
		State nextState = testState.evaluate('2');
		assertTrue(nextState instanceof IntegerState);
		assertEquals(52, nextState.getValue(), 0.0001);
		assertEquals(-1, nextState.getSign());
	}
	
	/**
	 * tests transitions to decimal state
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testTransitionToDecimalState() {
		State testState = new IntegerState(1,5);
		State nextState = testState.evaluate('.');
		assertTrue(nextState instanceof DecimalState);
		assertEquals(5, nextState.getValue(), 0.0001);
		assertEquals(1, nextState.getSign());
		assertEquals(.1f, nextState.getPoint(), 0.0001);
	}
	
	/**
	 * tests when finds null terminator
	 * @author Drew Rife and Brad Olah
	 */
	@Test
	public void testForNullTerminator() {
		State testState = new IntegerState(-1,5);
		State nextState = testState.evaluate('\0');
		assertTrue(nextState instanceof EndState);
		assertEquals(-5, nextState.getValue(), 0.0001);
	}
	
	/**
	 * tests for invalid character input
	 */
	@Test
	public void testForInvalidInput() {
		State testState = new IntegerState(1, 5);
		State nextState = testState.evaluate('>');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}
}