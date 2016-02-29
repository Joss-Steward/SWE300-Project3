/**
 * @author Drew Rife, Joss Steward, Brad Olah
 * 
 * The final state in the decimal parsing state machine.
 */
public class EndState extends BaseState {
	/**
	 * Generic Constructor
	 * @param value
	 */
	public EndState(double value) {
		this.value = value;
	}
	
	/**
	 * There are no valid transitions out of EndState, so if evaluate
	 * is called on EndState, it will set value to 0 and return a new
	 * EndState.
	 */
	public State evaluate(char character){
		value = 0;
		return new EndState(value);
	}
}