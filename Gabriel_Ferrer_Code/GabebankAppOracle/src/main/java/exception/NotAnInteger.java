package exception;

public class NotAnInteger extends Exception{
	public NotAnInteger() {
	}

	public NotAnInteger(String message) {
		super(message);
	}

	public NotAnInteger(String message, Throwable cause) {
		super(message, cause);
	}
}