/**
 * 
 */
package bud.exceptions;

/**
 * @author Knitter
 *
 */
public class LoginFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -956146291145014886L;

	/**
	 * 
	 */
	public LoginFailedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public LoginFailedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LoginFailedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public LoginFailedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
