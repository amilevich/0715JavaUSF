package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.account.UpdateAccountByCustomerDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Transaction;

public class TransactionService implements GeneralRepository<Transaction>{

	UpdateAccountByCustomerDao transaction = new UpdateAccountByCustomerDao();
	Transaction trans = new Transaction();
	@Override
	public boolean createRegister(Transaction t) {
		return transaction.updateAccount(t.getAccountNumber(), t.getAmount(), t.getKindTransaction(), t, t.getId());
	}

	@Override
	public List<Transaction> finAllRegister() {
		return null;
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
