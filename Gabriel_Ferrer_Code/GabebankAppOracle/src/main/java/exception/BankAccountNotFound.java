package exception;

public class BankAccountNotFound extends Exception {
public BankAccountNotFound() {}
	
	public BankAccountNotFound(String message) {
		super(message);
	}
	
	public BankAccountNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
