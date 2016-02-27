/**
 * 
 * @author Drew Rife
 *
 */
public interface State {

	int getSign();

	double getValue();
	
	double getPoint();
	
	State evaluate(char input);

}