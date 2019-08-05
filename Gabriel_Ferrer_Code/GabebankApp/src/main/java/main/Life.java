package main;

import data.*;
import model.*;

public class Life {
	public static void start() {
		///serialize objects
		Application.setAll( ApplicationSerializer.deserialize() );
		BankAccount.setAll( BankAccountSerializer.deserialize() );
		Customer.setAll( CustomerSerializer.deserialize() );
		Employee.setAll( EmployeeSerializer.deserialize() );
		UserAccount.setUserAccounts( UserAccountSerializer.deserialize() );
		///read Application and BankAccount counters
		Counter.read();
	}
	
	public static void playing() {
		Flow.main();
	}
	
	public static void end() {
		///Deserialize objects
		ApplicationSerializer.serialize( Application.getAll() );
		BankAccountSerializer.serialize( BankAccount.getAll() );
		CustomerSerializer.serialize( Customer.getAll() );
		EmployeeSerializer.serialize( Employee.getAll() );
		UserAccountSerializer.serialize( UserAccount.getUserAccounts() );
		///write Application and BankAccount counters to file
		Counter.write();
		System.exit(0);
	}
	
	public static void main(String[] args) {
		start();
		playing();
	}
}
