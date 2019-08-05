package Exceptions;

import Utils.MyLogger;

public class AccountLimitException extends Exception {

	AccountLimitException(){
		
	}
	
	public AccountLimitException(String msg){
		
		System.out.println(msg);
                MyLogger.log(msg);
	}
}
