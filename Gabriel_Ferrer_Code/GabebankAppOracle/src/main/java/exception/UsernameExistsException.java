package exception;

public class UsernameExistsException extends Exception {
	public UsernameExistsException() {}
	public UsernameExistsException(String message) {
		super(message);
	}
	
	public UsernameExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
