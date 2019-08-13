package com.bankdb.project.dao.implement;

import java.util.List;

import com.bankdb.project.dao.account.CreateAccountDao;
import com.bankdb.project.dao.account.FindAccountByIdDAO;
import com.bankdb.project.dao.account.FindAcounByCustomerDAO;
import com.bankdb.project.dao.account.FindAcounByCustomerJointDAO;
import com.bankdb.project.dao.account.UpdateAccountDAO;
import com.bankdb.project.inteface.GeneralRepository;
import com.bankdb.project.model.Account;
import com.bankdb.project.model.Person;

public class AccountDAOImpl implements GeneralRepository<Account> {
	
	CreateAccountDao account = new CreateAccountDao();
	FindAccountByIdDAO  findAccountById = new FindAccountByIdDAO();
	UpdateAccountDAO updateAcount = new UpdateAccountDAO();
	FindAcounByCustomerDAO custumerAccount = new FindAcounByCustomerDAO();
	FindAcounByCustomerJointDAO jcustumerAccount = new FindAcounByCustomerJointDAO();

	@Override
	public boolean createRegister(Account t) {
		return account.createRgister(t);
	}

	@Override
	public List<Account> finAllRegister() {
		return null;
	}
	
	
	public List<Account> finAllRegister(Person t, String typeAccount){
		return 	custumerAccount.findAllAccounts(t, typeAccount);	
	}
	
	public List<Account> finAllRegister(Person t, String typeAccount, String jType){
		return 	jcustumerAccount.findAllAccounts(t, typeAccount, jType);
	}

	@Override
	public Account findById(Account t) {
		return findAccountById.findById(t);
	}

	@Override
	public boolean updateRegister(Account t) {
		Account acct = new Account();
		acct = findAccountById.findById(t);
		if(acct != null) {
			if(t.getStatus().equals(acct.getStatus())) {
				return updateAcount.updateAccountAmount(t);
			}else {
				return updateAcount.updateAccountStatus(t);
			}
		}
		return false;
	}

	@Override
	public boolean deleteRegister(Account t) {
		return false;
	}	

}
