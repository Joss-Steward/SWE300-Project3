import static org.junit.Assert.*;

import org.junit.Test;


public class TestStartState {

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
		StateEnum nextState = testState.evaluate('1');
		
		assertEquals(nextState, StateEnum.IntegerState);
		assertEquals(1, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(1.0f, testState.getPoint(), 0.0001);
	}
	
	/**
	 * tests inputting a decimal
	 * @author Drew Rife, Brad Olah
	 */
	@Test
	public void testDecimal() {
		State testState = new StartState();
		StateEnum nextState = testState.evaluate('.');
		
		assertEquals(nextState, StateEnum.DecimalState);
		
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(0.1f, testState.getPoint(), 0.0001);
	}
	
	/**
	 * tests inputting anything that is
	 * not a digit or decimal point
	 */
	@Test
	public void testNonIntegerOrDecimal() {
		State testState = new StartState();
		StateEnum nextState = testState.evaluate('a');

		assertEquals(nextState, StateEnum.EndState);		
		assertEquals(0, testState.getValue(), 0.0001);		
	}
	
	/**
	 * Test a leading '-' sign
	 */
	@Test
	public void testNegativeSign() {
		State testState = new StartState();
		
		StateEnum nextState = testState.evaluate('-');
		
		assertEquals(nextState, StateEnum.IntegerState);
		
		assertEquals(-1, testState.getSign());
		assertEquals(0, testState.getValue(), 0.0001);		
	}
	
	/**
	 * Test a leading '+' sign
	 */
	@Test
	public void testPlusSign() {
		State testState = new StartState();
		
		StateEnum nextState = testState.evaluate('+');
		
		assertEquals(nextState, StateEnum.IntegerState);
		
		assertEquals(1, testState.getSign());
		assertEquals(0, testState.getValue(), 0.0001);
	}
}