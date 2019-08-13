package exception;

public class PersonCountException extends Exception {
	public PersonCountException() {}
	
	public PersonCountException(String message) {
		super(message);
	}
	
	public PersonCountException(String message, Throwable cause) {
		super(message, cause);
	}
}
