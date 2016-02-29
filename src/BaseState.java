/**
 * @author Drew Rife
 */

/**
 * @author Drew Rife
 *
 * The bass class that all states will extend
 */
public abstract class BaseState implements State {

	protected int sign; // the sign of the value
	protected double value; // the calculated value
	protected double point; // the multiplier that indicates where the decimal point is
	
	/**
	 * initializes sign, value, and point
	 * to their default values
	 */
	public BaseState() {
		sign = 1;
		value = 0;
		point = 1.0;
	}
	
	/**
	 * @return sign
	 */
	@Override
	public int getSign() {
		return sign;
	}

	/** 
	 * @return value
	 */
	@Override
	public double getValue() {
		return value;
	}
	
	/** 
	 * @return the decimal
	 */
	@Override
	public double getPoint() {
		return point;
	}
}