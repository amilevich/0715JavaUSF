package Exceptions;

import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidBalanceException extends Exception {

	InvalidBalanceException(){
		
	}
	public InvalidBalanceException(String msg){
		
		System.out.println(msg);
                MyLogger.log(msg);
		
	}
}
