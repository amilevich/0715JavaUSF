package com.bank.project.dao.account;

import java.util.ListIterator;

import com.bank.project.FileWriterTXT;
import com.bank.project.MainEntry;
import com.bank.project.model.Account;
import com.bank.project.model.Transaction;

public class UpdateAccountByCustomerDao {
	
	public boolean updateAccount(String account, double amount, char kindTrans, Transaction transaction, String idCustomer) {
		FileWriterTXT<Account> filename = new FileWriterTXT();	
		boolean flag = false;
		ListIterator<Account> actIterator = MainEntry.account.listIterator();
		Account acct;
		while(actIterator.hasNext()) {
			acct = actIterator.next();
			if((acct.getAccountNumber().equals(account)) && (acct.getId().equals(idCustomer))) {
				if(kindTrans == 'D') {
					acct.setAmount(acct.getAmount() + amount);	
					actIterator.set(acct);
				}else if(kindTrans == 'W') {
					
					//Exception to control negatives numbers
					if(acct.getAmount() > amount) {
						acct.setAmount(acct.getAmount() - amount);
						actIterator.set(acct);
					} else {
						System.out.println(" Is it less money you want ...");
						flag = false;
						break;
					}
				}
				
				flag = true;
				break;
			}
		}
		
		if(flag) {
			CreateTransactionDao transactionReg = new CreateTransactionDao();
			transactionReg.createTrans(transaction);
			return filename.updateFile(MainEntry.account, "./DataBase/Account.txt");
		}
		
		return flag;
		
	}

}
