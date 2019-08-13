package com.bank.app.mainInterface;

import java.util.List;

import com.AccountStuff.Accountinfo;
import com.AccountStuff.Accounts;
import com.accountDAO.CreateAccountDao;

public class Accountinfoimpl implements AccountInfoDAO {
	CreateAccountDao creac = new CreateAccountDao();

	@Override
	public int insert(Accounts accountinfo) {
		// TODO Auto-generated method stub
		return creac.createAccount(accountinfo);
	}

	@Override
	public Accountinfo selectAccountinfoByAccount_number(String account_number) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Accountinfo> selectAllAccountinfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateAccountinfo(Accounts accoutinfo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAccountinfo(Accounts accountinfo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
