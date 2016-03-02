/**
 * @author Drew Rife
 *
 */
public class Context {
	private static Context instance;
	private State startState;
	private State currentState;
	
	public Context() {
		instance = null;
		startState = new StartState();
		currentState = startState;
	}
	
	 public static Context getInstance() {
	      if(instance == null) {
	         instance = new Context();
	      }
	      return instance;
	 }
}
