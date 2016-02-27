/**
 * 
 * @author Drew Rife
 *
 */
public class IntegerState extends BaseState {
	private State nextState = null;
	
	public IntegerState(int sign, double value) {
		this.sign = sign;
		this.value = value;
	}
	
	public State evaluate(char input) {
		if(Character.isDigit(input)) {
			value *= 10;
			value += input - '0';
			nextState = new IntegerState(sign, value);
		}
		else if(input == '.') {
			point = .1;
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