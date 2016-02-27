import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author drew
 *
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