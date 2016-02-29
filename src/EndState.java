/**
 * 
 * @author Drew Rife
 *
 */
public class EndState extends BaseState {
	
	public EndState(double value) {
		this.value = value;
	}
	
	public State evaluate(char character) {
		return this;
	}
}