/**
 * @author Joss Steward
 *
 * Oversees running the state machine
 */
public class Manager {
	/**
	 * Store instances of each type of state.
	 */
	private StartState startState;
	private DecimalState decimalState;
	private IntegerState integerState;
	private EndState endState;

	// The current state
	private State currentState;
	
	public Manager() {
		startState = new StartState();
		decimalState = new DecimalState();
		integerState = new IntegerState();
		endState = new EndState();

		currentState = startState;
	}

	/**
	 * This method takes a string and returns the decimal 
	 *  representation of the string.  If the string cannot be
	 *  converted into a decimal, this will return 0. 
	 * @param inputString
	 * @return The decimal representation of the number in the string.
	 */
	public double ConvertToDecimal(String inputString){		
		/*
		 * Java stores the string length in the string object, so it won't
		 *  hit a null-terminating character in the for-each loop. By adding
		 *  one to the end of the string, we can nicely avoid making modifications
		 *  to the state machine. 
		 */
		inputString = inputString + '\0';
		
		for (char character : inputString.toCharArray()){
			StateEnum newState = currentState.evaluate(character);
			State nextState = null;
			
			if(newState == StateEnum.DecimalState) {
				nextState = decimalState;
			} else if(newState == StateEnum.IntegerState) {
				nextState = integerState;
			} else if(newState == StateEnum.EndState) {
				nextState = endState;
			} else {
				// There are no other valid transitions.
				//  If we wind up here, force an end.
				nextState = endState;				
			}
			
			nextState.setSign(currentState.getSign());
			nextState.setPoint(currentState.getPoint());
			nextState.setValue(currentState.getValue());
			
			currentState = nextState;
		}
		
		return currentState.getValue();
	}
}
