/**
 * 
 * @author Drew Rife
 *
 */
public class DecimalState extends BaseState {
	private State nextState = null;
	public DecimalState(int sign, double value, double point) {
		this.sign = sign;
		this.value = value;
		this.point = point;
	}
	
	public State evaluate(char input) {
		if(Character.isDigit(input)) {
			value += point * (input - '0');
			point /= 10;
			nextState = new DecimalState(sign, value, point); 
		}
		else if(input == '\0') {
			value *= sign;
			nextState = new EndState(value);
		}
		else {
			value = 0;
			nextState = new EndState(value);
		}
		return nextState;
	}
}