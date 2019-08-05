package exception;

public class UsernameInvalidException extends Exception {
	public UsernameInvalidException() {}
	public UsernameInvalidException(String message) {
		super(message);
	}
	
	public UsernameInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
}
