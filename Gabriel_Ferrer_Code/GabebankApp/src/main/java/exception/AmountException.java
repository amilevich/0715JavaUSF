package exception;

public class AmountException extends Exception {
	public AmountException() {}
	
	public AmountException(String message) {
		super(message);
	}
	
	public AmountException(String message, Throwable cause) {
		super(message, cause);
	}
}