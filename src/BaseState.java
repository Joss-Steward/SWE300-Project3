/**
 * @author Drew Rife
 */

/**
 * @author Drew Rife
 *
 */
public abstract class BaseState implements State {

	protected int sign;
	protected double value;
	protected double point;
	
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
		// TODO Auto-generated method stub
		return sign;
	}

	/** 
	 * @return value
	 */
	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return value;
	}
	
	/** 
	 * @return the decimal
	 */
	@Override
	public double getPoint() {
		// TODO Auto-generated method stub
		return point;
	}
	
	/**
	 * transitions to a new state 
	 * based on the input of the character
	 */
	@Override
	public State evaluate(char input) {
		return null;
	}

}