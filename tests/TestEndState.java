import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Joss Steward
 *
 */
public class TestEndState {
	/**
	 * Tests initialization of value
	 * @author Drew Rife, Joss Steward, Brad Olah
	 */
	@Test
	public void testInitialization() {
		State testState = new EndState(10.0);
		assertEquals(10.0f, testState.getValue(), 0.0001);	
	}

	/**
	 * Submits a digit to evaluate, and ensures 
	 *  that the new state returned is EndState 
	 *  with the Value set to 0.
	 * @author Joss Steward 
	 */
	@Test
	public void testTransitionWithDigit() {
		State testState = new EndState(10.0f);
		assertEquals(10.0f, testState.getValue(), 0.0001);	
		
		State nextState = testState.evaluate('0');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}

	/**
	 * Submits a non-digit to evaluate, and ensures 
	 *  that the new state returned is EndState 
	 *  with the Value set to 0.
	 * @author Joss Steward 
	 */
	@Test
	public void testTransitionWithNonDigit() {
		State testState = new EndState(10.0f);
		assertEquals(10.0f, testState.getValue(), 0.0001);	
		
		State nextState = testState.evaluate('f');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}

	/**
	 * Submits a terminator to evaluate, and ensures 
	 *  that the new state returned is EndState 
	 *  with the Value set to 0.
	 * @author Joss Steward 
	 */
	@Test
	public void testTransitionWithTerminator() {
		State testState = new EndState(10.0f);
		assertEquals(10.0f, testState.getValue(), 0.0001);	
		
		State nextState = testState.evaluate('\0');
		assertTrue(nextState instanceof EndState);
		assertEquals(0, nextState.getValue(), 0.0001);
	}

}
