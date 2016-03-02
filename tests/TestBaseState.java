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
	
	/**
	 * Test the sign setter
	 */
	@Test
	public void testSetSign(){
		State testState = new MockState();
		
		testState.setSign(-1);
		
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(-1, testState.getSign());
		assertEquals(1.0f, testState.getPoint(), 0.0001);
	}

	/**
	 * Test the value setter
	 */
	@Test
	public void testSetValue(){
		State testState = new MockState();
		
		testState.setValue(5);
		
		assertEquals(5, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(1.0f, testState.getPoint(), 0.0001);
	}

	/**
	 * Test the value setter
	 */
	@Test
	public void testSetPoint(){
		State testState = new MockState();
		
		testState.setPoint(0.001);
		
		assertEquals(0, testState.getValue(), 0.0001);
		assertEquals(1, testState.getSign());
		assertEquals(0.001f, testState.getPoint(), 0.0001);
	}
}