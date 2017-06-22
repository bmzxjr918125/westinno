package west.exception;
public class WestException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WestException() {
		super();
	}

	public WestException(String message, Throwable cause) {
		super(message, cause);
	}

	public WestException(String message) {
		super(message);
	}

	public WestException(Throwable cause) {
		super(cause);
	}
	
	
	
}
