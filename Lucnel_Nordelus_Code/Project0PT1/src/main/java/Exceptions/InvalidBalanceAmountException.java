package Exceptions;

import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidBalanceAmountException extends Exception {
	
	InvalidBalanceAmountException(){
		
	}
	
	public InvalidBalanceAmountException(String msg){
		
		System.out.println(msg);
		MyLogger.log(msg);
	}

}
