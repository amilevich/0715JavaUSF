package dao;

import com.drivers.DataDBDriver;
import com.mainmenu.MainScreen;
import com.uncertainty.Account;


public class AccountCreate {
	public boolean addtoDB(Account account) {
		String filename = "./account.txt";
		DataDBDriver<Account> driveDB = new DataDBDriver<>();
		return driveDB.writerFile(account, filename);
		
	}

}
