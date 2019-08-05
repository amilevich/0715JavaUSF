package com.bank.project.dao.account;

import com.bank.project.FileWriterTXT;
import com.bank.project.model.Transaction;

public class CreateTransactionDao {
	
	public boolean createTrans(Transaction transaction) {
		FileWriterTXT<Transaction> filename = new FileWriterTXT();
		return filename.writerFile(transaction, "./DataBase/Transaction.txt");
	}

}
