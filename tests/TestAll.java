import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import static org.junit.Assert.*;
import org.junit.Test;

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