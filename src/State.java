/**
 * 
 * @author Drew Rife
 *
 */
public interface State {

	int getSign();

	int getValue();
	
	double getPoint();
	
	State evaluate(char input);

}
