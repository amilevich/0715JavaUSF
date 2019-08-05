package Exceptions;

import Utils.MyLogger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerNotFoundException extends Exception {

	CustomerNotFoundException(){
		
	}
	public CustomerNotFoundException(String msg){
		
		System.out.println(msg);
                MyLogger.log(msg);
		
	}
}
