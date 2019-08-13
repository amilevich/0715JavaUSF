package exception;

public class PasswordInvalidException extends Exception{
	public PasswordInvalidException() {
	}

	public PasswordInvalidException(String message) {
		super(message);
	}

	public PasswordInvalidException(String message, Throwable cause) {
		super(message, cause);
	}
}
