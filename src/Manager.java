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
	public static double ConvertToDecimal(String inputString){
		State currentState = new StartState();
		
		for (char character : inputString.toCharArray()){
			currentState = currentState.evaluate(character);
			
			if(currentState instanceof EndState){
				break;
			}
		}
		
		return currentState.getValue();
	}
}
