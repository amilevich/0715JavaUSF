package Exceptions;

import Utils.MyLogger;

public class CloseAccountException extends Exception
{
	
	CloseAccountException(){
		
	}
	CloseAccountException(String msg){
		
		System.out.println(msg);
		MyLogger.log(msg);
	}

}
