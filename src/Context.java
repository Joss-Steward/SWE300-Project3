/**
 * @author Drew Rife
 *
 */
public class Context {
	/**
	 * Store instances of each type of state.
	 */
	private StartState startState;
	private DecimalState decimalState;
	private IntegerState integerState;
	private EndState endState;

	// The current state
	private static State currentState;

	// For the singleton
	private static Context instance;

	public Context() {
		instance = null;
		startState = new StartState();
		decimalState = new DecimalState();
		integerState = new IntegerState();
		endState = new EndState();

		currentState = startState;
	}

	/**
	 * Part of the singleton pattern
	 */
	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		
		return instance;
	}
}
