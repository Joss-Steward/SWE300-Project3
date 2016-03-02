import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author Drew Rife and Brad Olah
 *
 * Tests the functionality of Decimal State
 */
public class TestDecimalState {

	/**
	 * tests an integer input
	 * @author Drew Rife and Brad Olah and Joss Steward
	 */
	@Test
	public void testIntegerInput() {
		State testState = new DecimalState();
		
		testState.setSign(1);
		testState.setValue(5);
		testState.setPoint(0.1);
		
		StateEnum nextState = testState.evaluate('2');
		
		assertEquals(nextState, StateEnum.DecimalState);
		
		assertEquals(5.2, testState.getValue(), 0.0001);
		assertEquals(0.01, testState.getPoint(), 0.0001);
	}
	
	/**
	 * tests for null terminator
	 * @author Drew Rife and Brad Olah
	 */
	public void testNullTerminator() {
		State testState = new DecimalState();
		
		testState.setSign(-1);
		testState.setValue(5);
		testState.setPoint(0.1);
		
		StateEnum nextState = testState.evaluate('\0');

		assertEquals(nextState, StateEnum.EndState);
		assertEquals(-5, testState.getValue(), 0.0001);
	}
	
	/**
	 * tests for invalid input
	 * @author Drew Rife, Joss Steward, Brad Olah
	 */
	public void testInvalidInput() {
		State testState = new DecimalState();
		
		testState.setSign(-1);
		testState.setValue(5);
		testState.setPoint(0.1);
		
		StateEnum nextState = testState.evaluate('~');

		assertEquals(nextState, StateEnum.EndState);
		assertEquals(0, testState.getValue(), 0.0001);
	}
}