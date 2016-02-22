import static org.junit.Assert.*;

import org.junit.Test;


public class testStartState {

	@Test
	public void testInitialization() {
		State testState = new StartState();
		assertEquals(1, testState.getSign());
		assertEquals(0, testState.getValue());
		assertEquals(1.0f, testState.getPoint(), 0.0001);		
	}

	/**
	 * Submits a digit to evaluate, and ensures 
	 *  that the new state returned is Integer.
	 * @author Joss Steward 
	 */
	@Test
	public void testZeroDigit(){
		State testState = new StartState();
		State nextState = testState.evaluate('0');
		assertTrue(nextState instanceof IntegerState);
		assertEquals(0, nextState.getValue());
		assertEquals(1, nextState.getSign());
		assertEquals(1.0f, nextState.getPoint(), 0.0001);
	}
	
}
