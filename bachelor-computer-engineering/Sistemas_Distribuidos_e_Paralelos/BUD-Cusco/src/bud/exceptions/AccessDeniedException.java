/**
 * 
 */
package bud.exceptions;

/**
 * @author Knitter
 *
 */
public class AccessDeniedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3921683299522968271L;

	/**
	 * 
	 */
	public AccessDeniedException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public AccessDeniedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AccessDeniedException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public AccessDeniedException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
