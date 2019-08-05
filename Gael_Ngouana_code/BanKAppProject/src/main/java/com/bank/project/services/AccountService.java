package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.account.CreateAccountDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Account;

public class AccountService implements GeneralRepository<Account> {
	
	CreateAccountDao account = new CreateAccountDao();

	@Override
	public boolean createRegister(Account t) {
		return account.createRgister(t);
	}

	@Override
	public List<Account> finAllRegister() {
		return null;
	}

	@Override
	public Account findById(Account t) {
		return null;
	}

	@Override
	public boolean updateRegister(Account t) {
		return false;
	}

	@Override
	public boolean deleteRegister(Account t) {
		return false;
	}	

}
