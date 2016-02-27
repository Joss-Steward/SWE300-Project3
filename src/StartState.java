/**
 * 
 * @author Drew Rife
 *
 */
public class StartState extends BaseState{
	private State nextState = null;
	
	public StartState() {}
	public StartState(int sign) {
		this.sign = sign;
	}
	/**
	 * @input input - the next character to evaluate
	 * @returns IntegerState, if c is an integer, '+', or '-'
	 * @returns DecimalState, if c is '.'
	 * @returns EndState otherwise 
	 */
	@Override
	public State evaluate(char input) {
		if(Character.isDigit(input)){
			value = input - '0';
			nextState = new IntegerState(sign, value);
		}
		else if(input == '.') {
			point = .1;
			nextState = new DecimalState(sign, value, point);			
		}
		else if(input == '-') {
			sign = -1;
			nextState = new StartState(sign);
		}
		else {
			nextState = new EndState(value);
		}
		return nextState;
	}
}