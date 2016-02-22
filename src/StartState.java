/**
 * 
 * @author Drew Rife
 *
 */
public class StartState extends BaseState{

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
			return new IntegerState(sign, value, point);
		}
	}
}