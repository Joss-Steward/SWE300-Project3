/**
 * @author Drew Rife, Joss Steward
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
	
	/**
	 * @param sign - New value for Sign
	 */
	@Override
	public void setSign(int sign){
		this.sign = sign;
	}
	
	/**
	 * @param value - New value for Value
	 */
	@Override
	public void setValue(double value){
		this.value = value;
	}
	
	/**
	 * @param point - New value for Point
	 */
	@Override
	public void setPoint(double point){
		this.point = point;
	}
}