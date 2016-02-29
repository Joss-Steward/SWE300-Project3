import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Drew Rife
 *
 * Tests the functinality of BaseState
 */
public class TestBaseState {

	/**
	 * test for the initialization of
	 * s and v in StartState
	 */
	@Test
	public void testInitialization() {
		State testState = new MockState();
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(1.0f, testState.getPoint(), 0.0001);
	}
	
}