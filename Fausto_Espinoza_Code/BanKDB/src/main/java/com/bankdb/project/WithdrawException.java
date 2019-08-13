package com.bankdb.project;

public class WithdrawException extends Exception {
	
	public WithdrawException() {		
	}
	
	public WithdrawException(String message) {
		super(message);
	}
	
	public WithdrawException(String message, Throwable cause) {
		super(message, cause);
	}

}
