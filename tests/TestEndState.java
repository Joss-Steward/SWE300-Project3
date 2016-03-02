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
		State testState = new EndState();
		
		testState.setValue(10.0);
		
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
		State testState = new EndState();
		
		testState.setValue(10.0);
		assertEquals(10.0f, testState.getValue(), 0.0001);	
		
		StateEnum nextState = testState.evaluate('0');
		
		assertEquals(nextState, StateEnum.EndState);
		assertEquals(0, testState.getValue(), 0.0001);
	}

	/**
	 * Submits a non-digit to evaluate, and ensures 
	 *  that the new state returned is EndState 
	 *  with the Value set to 0.
	 * @author Joss Steward 
	 */
	@Test
	public void testTransitionWithNonDigit() {
		State testState = new EndState();
		
		testState.setValue(10.0);		
		assertEquals(10.0f, testState.getValue(), 0.0001);	
		
		StateEnum nextState = testState.evaluate('f');
		
		assertEquals(nextState, StateEnum.EndState);
		assertEquals(0, testState.getValue(), 0.0001);
	}

	/**
	 * Submits a terminator to evaluate, and ensures 
	 *  that the new state returned is EndState 
	 *  with the Value set to 0.
	 * @author Joss Steward 
	 */
	@Test
	public void testTransitionWithTerminator() {
		State testState = new EndState();
		
		testState.setValue(10.0);
		assertEquals(10.0f, testState.getValue(), 0.0001);	

		StateEnum nextState = testState.evaluate('\0');
		
		assertEquals(nextState, StateEnum.EndState);
		assertEquals(0, testState.getValue(), 0.0001);
	}

}
