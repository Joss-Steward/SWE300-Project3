import static org.junit.Assert.*;

import org.junit.Test;


public class testStartState {

	/**
	 * Tests initialization of 
	 * sign, value and point
	 * @author Drew Rife, Joss Steward, Brad Olah
	 */
	@Test
	public void testInitialization() {
		State testState = new StartState();
		assertEquals(1, testState.getSign());
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(1.0f, testState.getPoint(), 0.0001);		
	}

	/**
	 * Submits a digit to evaluate, and ensures 
	 *  that the new state returned is Integer.
	 * @author Joss Steward 
	 */
	@Test
	public void testInteger() {
		State testState = new StartState();
		State nextState = testState.evaluate('0');
		assertTrue(nextState instanceof IntegerState);
		assertEquals(0, nextState.getValue(), 0.0001);
		assertEquals(1, nextState.getSign());
		assertEquals(1.0f, nextState.getPoint(), 0.0001);
	}
	
	/**
	 * tests inputting a decimal
	 * @author Drew Rife, Brad Olah
	 */
	@Test
	public void testDecimal() {
		State testState = new StartState();
		State nextState = testState.evaluate('.');
		assertTrue(nextState instanceof DecimalState);
		assertEquals(0, nextState.getValue(), 0.0001);
		assertEquals(1, nextState.getSign());
		assertEquals(0.1f, nextState.getPoint(), 0.0001);
	}
	
	/**
	 * tests inputting anything that is
	 * not a digit or decimal point
	 */
	@Test
	public void testNonIntegerOrDecimal() {
		State testState = new StartState();
		State nextState = testState.evaluate('a');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
		
		nextState = testState.evaluate('}');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}
	
	/**
	 * 
	 */
	@Test
	public void testNegativeInteger() {
		State testState = new StartState();
		State nextState = testState.evaluate('-');
		assertTrue(nextState instanceof StartState);
		assertEquals(-1, nextState.getSign());
		assertEquals(0, nextState.getValue(), 0.0001);
		
		nextState = nextState.evaluate('5');
		assertTrue(nextState instanceof IntegerState);
		assertEquals(-1, nextState.getSign());
		assertEquals(5, nextState.getValue(), 0.0001);
	}
}