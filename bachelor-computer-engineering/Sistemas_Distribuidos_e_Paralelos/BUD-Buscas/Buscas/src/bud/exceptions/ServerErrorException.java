/**
 * 
 */
package bud.exceptions;

/**
 * @author Knitter
 *
 */
public class ServerErrorException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -52326552681490614L;

	/**
	 * 
	 */
	public ServerErrorException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ServerErrorException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServerErrorException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ServerErrorException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
