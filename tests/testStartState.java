import static org.junit.Assert.*;
import org.junit.Test;

/**
 * 
 * @author Drew Rife
 *
 */
public class testStartState {

	/**
	 * test for the initialization of
	 * s and v in StartState
	 */
	@Test
	public void testInitialization() {
		State testState = new StartState();
		assertEquals(0, testState.getValue());
		assertEquals(1, testState.getSign());
	}
}