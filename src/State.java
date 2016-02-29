/**
 * @author Drew Rife
 *
 */
public interface State {
	/** 
	 * @return Sign
	 */
	int getSign();

	/**
	 * @return Value
	 */
	double getValue();
	
	/**
	 * @return Point
	 */
	double getPoint();
	
	/**
	 * Evaluate the character and return the new state
	 * @param input - The character to evaluate
	 * @return The new state
	 */
	State evaluate(char input);

}