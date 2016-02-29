import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Drew Rife and Joss Steward
 *
 * Runs all tests
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestBaseState.class,
			TestStartState.class,
			TestIntegerState.class,
			TestDecimalState.class,
			TestEndState.class,
			TestManager.class
		})
public class TestAll {}