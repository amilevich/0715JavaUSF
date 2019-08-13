package main;

import data.dao.*;
import model.*;
import utility.ds.ArrayOps;
import utility.print.Balance;
import utility.print.Table;
import value.AccountSharing;
import value.ApplicationStatus;
import value.Currency;

public class Actions {
	//// no recursion or loop allowed here
	//// only a set of actions to execute when called
	////DAOIs
	private static ApplicationDAOI appdao = new ApplicationDAOI();
	private static BankAccountDAOI bankdao = new BankAccountDAOI();
	private static CustomerDAOI custdao = new CustomerDAOI();
	
	////Objects of POJOs
	private static Application editApp = new Application();
	private static Application newApp = new Application();
	private static AccountDetail newAD = new AccountDetail();
	private static Applicant newAppIndv = new Applicant();
	public static BankAccount origBankAcct = new BankAccount();
	private static BankAccount destBankAcct = new BankAccount();
	public static Customer customer = new Customer();
	
	////Objects of Values
	private static Currency currency;
	
	public static void run(Integer condition) {
		switch (condition) {
			case 0:
				Life.end();
				break;
			case 1: break;
			case 2: break;
			case 3: break;
			case 4: 
				Life.end();
				break;
			case 5: break;
			case 6: break;
			case 7: 
				Life.end();
				break;
			case 8: break;
			case 9: break;
			case 10: break;
			case 11: break;
			case 12: break;
			case 13: break;
			case 14: break;
			case 15: break;
			case 16: 
				Life.end();
				break;
			case 17:
				//case for INDIVIDUAL
				newAD.setAmount(  Form.getDbl(condition)  );
				break;
			case 18: 
				currency = Currency.valueOf( Form.getStr(condition).toUpperCase()  );
				newAD.setCurrency(currency);
				newAD.setAccountSharing(AccountSharing.INDIVIDUAL);
				newApp.setAccountDetail(newAD);
				
				break;
			case 19: 
				newAppIndv.setFirstName( Form.getStr(condition).toUpperCase() );
				break;
			case 20: 
				newAppIndv.setLastName( Form.getStr(condition).toUpperCase() );
				break;
			case 21: 
				newAppIndv.setUsername( Form.getStr(condition).toLowerCase() );
				break;
			case 22: 
				newAppIndv.setPassword( Form.getStr(condition) );
				newApp.addApplicant(newAppIndv);
				
				appdao.insertOne(newApp); // insert new application
				
				newAppIndv = new Applicant(); // point to an empty applicant object
				newAD = new AccountDetail(); // point to an empty account detail object
				newApp = new Application(); // point to an empty application object
				break;
			case 23: 
				// case for JOINT
				newAD.setAmount( Form.getDbl(condition) );
				break;
			case 24: 
				currency = Currency.valueOf( Form.getStr(condition).toUpperCase()  );
				
				newAD.setCurrency(currency);
				newAD.setAccountSharing(AccountSharing.JOINT);
				newApp.setAccountDetail(newAD);
				
				newAD = new AccountDetail();
				break;
			case 25: 
				newAppIndv.setFirstName( Form.getStr(condition).toUpperCase() );
				break;
			case 26: 
				newAppIndv.setLastName( Form.getStr(condition).toUpperCase() );
				break;
			case 27: 
				Form.addUsers( Form.getStr(27).toLowerCase() );
				newAppIndv.setUsername( Form.getStr(27).toLowerCase() );
				break;
			case 28: 
				newAppIndv.setPassword( Form.getStr(28) );
				
				newApp.addApplicant(  newAppIndv  );
				newAppIndv = new Applicant();
				
				Integer numberOfLoops = Form.getInt(65);
				if (numberOfLoops > 1) { // keep executing this until no more will be entered 					
					Form.saveAnswer(65, String.valueOf(--numberOfLoops));
					Menu.start(10);
				} else { // if all unique joint users are entered, save the info to db and go back to first qgrp
					appdao.insertOne(newApp); // insert a new application
					newApp = new Application();
				}
				
				break;
			case 29: 
			case 30: 
			case 31: 
				origBankAcct = bankdao.getOne( customer.getBankAccountNumber() );
				Balance.run( origBankAcct );
				break;
			case 32: 
				Life.end();
				break;
			case 33: break; 
			case 34:
				origBankAcct.deposit(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				Balance.run( origBankAcct );
				break;  // deposit money to an instance of the source bank account
			case 35: break;
			case 36:
				origBankAcct.withdraw(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				Balance.run( origBankAcct );
				break;  // withdraw money from an instance of the source bank account
			case 37: 
				//origBankAcct = bankdao.getOne( Form.getInt(condition) );
				break;  // get an instance of the source bank account given a bank account number 
			case 38: 
				// get an instance of the source bank account given a bank account number
				origBankAcct = bankdao.getOne( customer.getBankAccountNumber() );
				destBankAcct = bankdao.getOne( Form.getInt(condition) );
				break;  // get an instance of the recipient bank account given a bank account number
			case 39: 
				// withdraw money from the source bank account
				// deposit money to the recipient bank account
				origBankAcct.withdraw(  Form.getDbl(condition)  );
				destBankAcct.deposit(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				bankdao.updateOne(destBankAcct);
				Balance.run( origBankAcct );
				break;
			case 40: break;
			case 41: break;
			case 42: break;
			case 43: 
				Life.end();
				break;
			case 44: 
				origBankAcct = bankdao.getOne( Form.getInt(condition) );
				break;  // get an instance of the source bank account given a bank account number
			case 45: 
				origBankAcct.deposit(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				Balance.run( origBankAcct );
				break;  // deposit money to an instance of the source bank account
			case 46: 
				origBankAcct = bankdao.getOne( Form.getInt(condition) );
				break;  // get an instance of the source bank account given a bank account number
			case 47: 
				origBankAcct.withdraw(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				Balance.run( origBankAcct );
				break;  // withdraw money from an instance of the source bank account
			case 48: 
				// get an instance of the source bank account given a bank account number
				origBankAcct = bankdao.getOne( Form.getInt(condition) );
				All.bass.clear(); // clears the original selection of all bank accounts without regard to currency
				// gets all the bank accounts with currencies matching the source bank account
				All.bass = ArrayOps.arrStringToIntegerSet( bankdao.getTable() , 2, origBankAcct.getCurrency().name());
				All.bass.remove( Form.getInt(condition) ); // remove the source bank account among choices
				break;  
			case 49: 
				destBankAcct = bankdao.getOne( Form.getInt(condition) );
				break;  // get an instance of the recipient bank account given a bank account number
			case 50: 
				// withdraw money from the source bank account
				// deposit money to the recipient bank account
				origBankAcct.withdraw(  Form.getDbl(condition)  );
				destBankAcct.deposit(  Form.getDbl(condition)  );
				bankdao.updateOne(origBankAcct);
				bankdao.updateOne(destBankAcct);
				Balance.run( origBankAcct );
				break;
			case 51:
			case 52:
				All.appss = ArrayOps.arrStringToIntegerSet(  appdao.getTable() );
				Table.displayArray("All Open Applications", All.ah, appdao.getTable());
				break;
			case 53: 
				Table.displayArray("All Account Holders", All.ch, custdao.getTable());
				break;
			case 54: 
				Table.displayArray("All Bank Accounts", All.bh, bankdao.getTable());
				break;
			case 55: 
				Life.end();
				break;
			case 56: 
			case 57: 
				All.appss = ArrayOps.arrStringToIntegerSet(  appdao.getTable() );
				Table.displayArray("All Open Applications", All.ah, appdao.getTable());
				break;
			case 58: 
				Table.displayArray("All Account Holders", All.ch, custdao.getTable());
				break;
			case 59:
			case 60: 
			case 61: 
				All.bass = ArrayOps.arrStringToIntegerSet(  bankdao.getTable() );
				Table.displayArray("All Bank Accounts", All.bh, bankdao.getTable());
				break;
			case 62: 
				All.custss = ArrayOps.arrStringToStringSet(  custdao.getTable() );
				Table.displayArray("All Account Holders", All.ch, custdao.getTable());
				break;
			case 63: 
				Life.end();
				break;
			case 64: 
				origBankAcct = bankdao.getOne(  Form.getInt(condition)  );
				bankdao.deleteOne( Form.getInt(condition)  );
				System.out.println( "Bank account "+ origBankAcct.getNumber() +" is successfully closed");
				System.out.println( "Giving back the customer " + origBankAcct.getCurrency().name() + " "+ origBankAcct.getAmount());
				break;
			case 65: break;
			case 66:
				editApp = appdao.getOne( Form.getInt(condition) );
				editApp.setAppStatus(ApplicationStatus.APPROVED);
				appdao.updateOne(editApp);
				break;
			case 67:
				editApp = appdao.getOne( Form.getInt(condition) );
				editApp.setAppStatus(ApplicationStatus.DENIED);
				appdao.updateOne(editApp);
				break;
			case 68:
				editApp = appdao.getOne( Form.getInt(condition) );
				editApp.setAppStatus(ApplicationStatus.APPROVED);
				appdao.updateOne(editApp);
				break;
			case 69:
				editApp = appdao.getOne( Form.getInt(condition) );
				editApp.setAppStatus(ApplicationStatus.DENIED);
				appdao.updateOne(editApp);
				break;
			case 70: break;
			case 71: break;
			case 72:
				Customer cust = custdao.getOne( Form.getStr(70) );
				cust.setFirstName(Form.getStr(71).toUpperCase());
				cust.setLastName(Form.getStr(72).toUpperCase());
				custdao.updateOne(cust);
				System.out.println();
				break;
		}
	}
}
