/**
 * 
 * @author Drew Rife, Joss Steward, Brad Olah
 *
 * Valid transitions: IntegerState, DecimalState, EndState
 */
public class IntegerState extends BaseState {
	/**
	 * Generic Constructor
	 * @param sign
	 * @param value
	 */
	public IntegerState(int sign, double value) {
		this.sign = sign;
		this.value = value;
	}
	
	/**
	 * takes a character as an input and
	 * transitions to one of the following states:
	 * 'Digit' -> IntegerState
	 * '.' -> DecimalState
	 * 'Other' -> EndState
	 * '\0' -> EndState
	 */
	public State evaluate(char input) {
		State nextState = null;
		
		if(Character.isDigit(input)) {
			// Apply the next digit and Transition to IntegerState
			value *= 10;
			value += input - '0';
			nextState = new IntegerState(sign, value);
		}
		else if(input == '.') {
			// Set point to 0.1 and transition to DecimalState
			point = .1;
			nextState = new DecimalState(sign, value, point);
		}
		else if(input == '\0') {
			// We've hit the end, so transition to EndState
			value *= sign;
			nextState = new EndState(value);
		}
		else {
			// Otherwise, transition to EndState
			value = 0;
			nextState = new EndState(value);
		}
		
		// Return the new state
		return nextState;
	}
}