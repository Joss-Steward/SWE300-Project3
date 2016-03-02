import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Drew Rife and Brad Olah
 * 
 * Tests the functinality of integer state
 */
public class TestIntegerState {

	/**
	 * tests initialization of
	 * sign and value
	 * @author Drew Rife and Brad Olah and Joss Steward
	 */
	@Test
	public void testInitialization() {
		State testState = new IntegerState();
		
		testState.setSign(1);
		testState.setValue(5);
		
		assertEquals(1, testState.getSign());
		assertEquals(5, testState.getValue(), 0.0001);
	}
	
	/**
	 * tests that it stays in Integer State
	 * @author Drew Rife and Brad Olah and Joss Steward
	 */
	@Test
	public void testStaysInIntegerState() {
		State testState = new IntegerState();
		
		testState.setSign(-1);
		testState.setValue(5);
		
		StateEnum nextState = testState.evaluate('2');
		
		assertEquals(nextState, StateEnum.IntegerState);
		
		assertEquals(52, testState.getValue(), 0.0001);
		assertEquals(-1, testState.getSign());
	}
	
	/**
	 * tests transitions to decimal state
	 * @author Drew Rife and Brad Olah and Joss Steward
	 */
	@Test
	public void testTransitionToDecimalState() {
		State testState = new IntegerState();
		
		testState.setSign(1);
		testState.setValue(5);
		testState.setPoint(0);
		
		StateEnum nextState = testState.evaluate('.');
		
		assertEquals(nextState, StateEnum.DecimalState);
		
		assertEquals(5, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(.1f, testState.getPoint(), 0.0001);
	}
	
	/**
	 * tests when finds null terminator
	 * @author Drew Rife and Brad Olah and Joss Steward
	 */
	@Test
	public void testForNullTerminator() {
		State testState = new IntegerState();
		
		testState.setSign(-1);
		testState.setValue(5);
		
		StateEnum nextState = testState.evaluate('\0');
		
		assertEquals(nextState, StateEnum.EndState);
		assertEquals(-5, testState.getValue(), 0.0001);
	}
	
	/**
	 * tests for invalid character input
	 */
	@Test
	public void testForInvalidInput() {
		State testState = new IntegerState();
		
		testState.setSign(1);
		testState.setValue(5);
		
		StateEnum nextState = testState.evaluate('>');
		
		assertEquals(nextState, StateEnum.EndState);
		assertEquals(0, testState.getValue(), 0.0001);
	}
}