package src.com.john.ui;

import java.util.HashSet;
import java.util.Set;

import src.com.john.core.Account;
import src.com.john.core.AccountManager;
import src.com.john.core.User;
import src.com.john.core.UserManager;
import src.com.john.dao.AccountDAOImpl;
import src.com.john.dao.UserDAOImpl;

public class DataBaser
{
	AccountDAOImpl accounter;
	UserDAOImpl userer;
	
	public AccountManager am;
	public UserManager um;
	
	public DataBaser()
	{
		accounter = new AccountDAOImpl();
		userer = new UserDAOImpl();
		
		um = loadUserManager();
		am = loadAccountManager();
	}
	
	private AccountManager loadAccountManager()
	{
		AccountManager loaded_am = new AccountManager(accounter.selectAllAccounts());
		
		return loaded_am;
	}
	
	private UserManager loadUserManager()
	{
		UserManager loaded_um = new UserManager(userer.selectAllUsers());
		
		return loaded_um;
	}
	
	public void save(UserManager um, AccountManager am)
	{
		saveUserManager(um);
		saveAccountManager(am);
	}
	
	private void saveUserManager(UserManager um)
	{
		for(User user : um.newusers) {
			userer.insert(user);
		}
	}
	
	private void saveAccountManager(AccountManager am)
	{
		accounter.truncate();
		
		HashSet<Account> uniqueAccounts = new HashSet<Account>();
		
		Set<String> keys = am.getKeySet();
		
		for(String key : keys)
		{
			for(Account account : am.getAccounts(key))
			{
				uniqueAccounts.add(account);
				
				//accounter.insert(account);
			}
		}
		
		for(Account account : uniqueAccounts)
		{
			accounter.insert(account);
		}
	}
}