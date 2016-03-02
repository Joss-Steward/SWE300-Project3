/**
 * 
 * @author Drew Rife, Joss Steward, Brad Olah
 *
 * Valid transitions: DecimalState, EndState
 */
public class DecimalState extends BaseState {
	
	public DecimalState() {
		// Does nothing
	}

	/**
	 * takes a character as an input and
	 * transitions to one of the following states:
	 * 'Digit' -> DecimalState
	 * 'Other' -> EndState
	 * '\0' -> EndState
	 */
	public StateEnum evaluate(char input) {
		StateEnum nextState = null; 
		
		if(Character.isDigit(input)) {
			// We got a valid digit, so apply it to the value and transition
			// to the DecimalState.
			value += point * (input - '0');
			point /= 10;
			nextState = StateEnum.DecimalState; 
		}
		else if(input == '\0') {
			// If we get a null terminator, then we are at the end of the string.
			// Set value to the end value and transition to the EndState.
			value *= sign;
			nextState = StateEnum.EndState;
		}
		else {
			// If we get an invalid character then we can't parse this string...
			// Set value to 0 and transition to EndState.
			value = 0;
			nextState = StateEnum.EndState;
		}
		return nextState;
	}
}