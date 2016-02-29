/**
 * 
 * @author Drew Rife, Joss Steward, Brad Olah
 *
 * Valid transitions; DecimalState, EndState
 */
public class DecimalState extends BaseState {
	
	/**
	 * Generic constructor
	 * @param sign
	 * @param value
	 * @param point
	 */
	public DecimalState(int sign, double value, double point) {
		this.sign = sign;
		this.value = value;
		this.point = point;
	}
	
	/**
	 * takes a character as an input and
	 * transitions to one of the following states:
	 * 'Digit' -> DecimalState
	 * 'Other' -> EndState
	 * '\0' -> EndState
	 */
	public State evaluate(char input) {
		State nextState = null; 
		
		if(Character.isDigit(input)) {
			// We got a valid digit, so apply it to the value and transition
			// to the DecimalState.
			value += point * (input - '0');
			point /= 10;
			nextState = new DecimalState(sign, value, point); 
		}
		else if(input == '\0') {
			// If we get a null terminator, then we are at the end of the string.
			// Set value to the end value and transition to the EndState.
			value *= sign;
			nextState = new EndState(value);
		}
		else {
			// If we get an invalid character then we can't parse this string...
			// Set value to 0 and transition to EndState.
			value = 0;
			nextState = new EndState(value);
		}
		return nextState;
	}
}