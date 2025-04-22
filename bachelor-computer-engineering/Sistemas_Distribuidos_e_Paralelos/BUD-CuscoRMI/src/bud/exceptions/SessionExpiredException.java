/**
 * 
 */
package bud.exceptions;

/**
 * @author knitter
 *
 */
public class SessionExpiredException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1792296808101002093L;

	/**
	 * 
	 */
	public SessionExpiredException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public SessionExpiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public SessionExpiredException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public SessionExpiredException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
