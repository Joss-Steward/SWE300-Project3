import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author drew
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			testBaseState.class,
			testDecimalState.class,
			testIntegerState.class,
			testStartState.class
		})
public class TestAll {}