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
	 * @param sign - New value for Sign
	 */
	void setSign(int sign);
	
	/**
	 * @param value - New value for Value
	 */
	void setValue(double value);
	
	/**
	 * @param point - New value for Point
	 */
	void setPoint(double point);
	
	/**
	 * Evaluate the character and return the new state
	 * @param input - The character to evaluate
	 * @return The new state
	 */
	StateEnum evaluate(char input);
}