package exception;

public class LetterOnlyException extends Exception {
	public LetterOnlyException() {}
	public LetterOnlyException(String message) {
		super(message);
	}
	
	public LetterOnlyException(String message, Throwable cause) {
		super(message, cause);
	}
}
