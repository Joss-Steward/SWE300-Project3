/**
 * 
 * @author Drew Rife, Joss Steward
 *
 * Valid Transitions: IntegerState, DecimalState, EndState
 */
public class StartState extends BaseState{
	
	public StartState() {}	

	/**
	 * takes a character as an input and
	 * transitions to one of the following states:
	 * 'Digit' -> IntegerState
	 * '.' -> DecimalState
	 * '-' -> IntegerState
	 * '+' -> IntegerState
	 * 'Other' -> EndState
	 */
	@Override
	public State evaluate(char input) {
		State nextState = null;
		
		if(Character.isDigit(input)){
			// Transition to IntegerState
			value = input - '0';
			nextState = new IntegerState(sign, value);
		}
		else if(input == '.') {
			// Transition to DecimalState
			point = .1;
			nextState = new DecimalState(sign, value, point);			
		}
		else if(input == '-') {
			// Transition to IntegerState
			sign = -1;
			nextState = new IntegerState(sign, value);
		}
		else if(input == '+') {
			// Transition to IntegerState
			nextState = new IntegerState(sign, value);
		}
		else {
			// Transition to EndState
			nextState = new EndState(value);
		}
		return nextState;
	}
}