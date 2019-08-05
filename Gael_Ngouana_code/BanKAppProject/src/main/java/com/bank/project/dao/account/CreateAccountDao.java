package com.bank.project.dao.account;


import com.bank.project.FileWriterTXT;
import com.bank.project.model.Account;

public class CreateAccountDao {
	
	public boolean createRgister(Account account) {
		FileWriterTXT<Account> filename = new FileWriterTXT();		
		return filename.writerFile(account, "./DataBase/Account.txt");
	}

}
