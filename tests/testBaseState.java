import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Drew Rife
 *
 */
public class testBaseState {

	/**
	 * test for the initialization of
	 * s and v in StartState
	 */
	@Test
	public void testInitialization() {
		State testState = new MockState();
		assertEquals(0, testState.getValue());
		assertEquals(1, testState.getSign());
		assertEquals(1.0f, testState.getPoint(), 0.0001);
	}
	
	@Test
	public void testEvaluate() {
		State testState = new MockState();
		assertNull(testState.evaluate('c'));
	}
}