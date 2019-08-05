package Exceptions;

import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccountNotFound extends Exception {
	
	AccountNotFound(){
		
	}
	
	public AccountNotFound(String msg){
		
		System.out.println(msg);
		MyLogger.log(msg);
	}

}
