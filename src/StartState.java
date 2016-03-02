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
	public StateEnum evaluate(char input) {
		StateEnum nextState = null;
		
		if(Character.isDigit(input)){
			// Transition to IntegerState
			value = input - '0';
			nextState = StateEnum.IntegerState;
		}
		else if(input == '.') {
			// Transition to DecimalState
			point = .1;
			nextState = StateEnum.DecimalState;			
		}
		else if(input == '-') {
			// Transition to IntegerState
			sign = -1;
			nextState = StateEnum.IntegerState;
		}
		else if(input == '+') {
			// Transition to IntegerState
			nextState = StateEnum.IntegerState;
		}
		else {
			// Transition to EndState
			nextState = StateEnum.EndState;
		}
		return nextState;
	}
}