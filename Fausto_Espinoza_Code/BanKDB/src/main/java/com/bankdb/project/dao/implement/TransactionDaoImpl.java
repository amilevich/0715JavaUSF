package com.bankdb.project.dao.implement;

import java.util.List;

import com.bankdb.project.dao.transaction.CreateTransactionDAO;
import com.bankdb.project.dao.transaction.FindTransactionByIdDAO;
import com.bankdb.project.inteface.GeneralRepository;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Transaction;

public class TransactionDaoImpl implements GeneralRepository<Transaction>{
	CreateTransactionDAO createTransaction = new CreateTransactionDAO();
	FindTransactionByIdDAO findAllReg = new FindTransactionByIdDAO();

	@Override
	public boolean createRegister(Transaction t) {
		return createTransaction.createTransation(t);
	}

	@Override
	public List<Transaction> finAllRegister() {
		return null;
	}
	
	public List<Transaction> finAllRegister(Account t){
		return 	findAllReg.finAll(t);	
	}
	
	@Override
	public Transaction findById(Transaction t) {
		return null;
	}

	@Override
	public boolean updateRegister(Transaction t) {
		return false;
	}

	@Override
	public boolean deleteRegister(Transaction t) {
		return false;
	}
		

}
