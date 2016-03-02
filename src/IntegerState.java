/**
 * 
 * @author Drew Rife, Joss Steward, Brad Olah
 *
 * Valid transitions: IntegerState, DecimalState, EndState
 */
public class IntegerState extends BaseState {
	
	public IntegerState() {
		// Does Nothing
	}

	/**
	 * takes a character as an input and
	 * transitions to one of the following states:
	 * 'Digit' -> IntegerState
	 * '.' -> DecimalState
	 * 'Other' -> EndState
	 * '\0' -> EndState
	 */
	public StateEnum evaluate(char input) {
		StateEnum nextState = null;
		
		if(Character.isDigit(input)) {
			// Apply the next digit and Transition to IntegerState
			value *= 10;
			value += input - '0';
			nextState = StateEnum.IntegerState;
		}
		else if(input == '.') {
			// Set point to 0.1 and transition to DecimalState
			point = .1;
			nextState = StateEnum.DecimalState;
		}
		else if(input == '\0') {
			// We've hit the end, so transition to EndState
			value *= sign;
			nextState = StateEnum.EndState;
		}
		else {
			// Otherwise, transition to EndState
			value = 0;
			nextState = StateEnum.EndState;
		}
		
		// Return the new state
		return nextState;
	}
}