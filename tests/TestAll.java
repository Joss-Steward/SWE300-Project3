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
			TestDecimalState.class,
			TestIntegerState.class,
			TestStartState.class,
			TestManager.class
		})
public class TestAll {}