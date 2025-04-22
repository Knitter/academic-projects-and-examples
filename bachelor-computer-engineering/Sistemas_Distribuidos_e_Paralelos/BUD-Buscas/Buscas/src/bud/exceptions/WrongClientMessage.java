/**
 * 
 */
package bud.exceptions;

/**
 * @author knitter
 *
 */
public class WrongClientMessage extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2284435377283015153L;

	/**
	 * 
	 */
	public WrongClientMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public WrongClientMessage(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WrongClientMessage(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public WrongClientMessage(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
