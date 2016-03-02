/**
 * @author Joss Steward
 *
 * Oversees running the state machine
 */
public class Manager {

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
			currentState = currentState.evaluate(character);
		}
		
		return currentState.getValue();
	}
}
