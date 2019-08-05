package exception;

public class UserAccountNotFound extends Exception {
	public UserAccountNotFound() {}
	
	public UserAccountNotFound(String message) {
		super(message);
	}
	
	public UserAccountNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
