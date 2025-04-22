/**
 * 
 */
package bud.exceptions;

/**
 * @author Knitter
 *
 */
public class ClientWithoutServerException extends RuntimeException {


	private static final long serialVersionUID = 1654461415777484922L;

	public ClientWithoutServerException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public ClientWithoutServerException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ClientWithoutServerException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public ClientWithoutServerException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
