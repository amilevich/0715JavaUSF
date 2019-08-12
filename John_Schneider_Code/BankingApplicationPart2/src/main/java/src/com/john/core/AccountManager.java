package src.com.john.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AccountManager implements Serializable
{
	private static final long serialVersionUID = -3094210768138164924L;
	
	//Map to hold users and an arraylist of their associated accounts
	public Map<String, ArrayList<Account>> userAccounts = new HashMap<>();
	
	public AccountManager() {
	}
	
	public AccountManager(ArrayList<Account> accounts) {
		for(Account a : accounts)
		{
			this.addAccount(a.getPrimaryOwner(), a);
			
			if(a.getJointOwner() != null)
				this.addAccount(a.getJointOwner(), a);
		}
	}
	
	public void addNewAccount(User primaryOwner, int type, User jointOwner)
	{
		Account newAccount;
		
		int newId = getTotalAccountNumber()+1;
		
		if(type == 1) {
			newAccount = new CheckingsAccount(newId, primaryOwner, jointOwner);
		} else if(type == 2) {
			newAccount = new SavingsAccount(newId, primaryOwner, jointOwner);
		} else return;
		
		addAccount(primaryOwner.getUsername(), newAccount);
		
		if(jointOwner != null) {
			addAccount(jointOwner.getUsername(), newAccount);
		}
	}
	
	public int getTotalAccountNumber()
	{
		Set<String> users = getKeySet();
		
		int count = 1;
		
		if(users == null)
			return count;
		
		for(String s : users)
		{
			for(Account account : userAccounts.get(s))
			{
				if(account.getId() > count)
					count = account.getId();
			}
		}
		
		return count;
	}
	
	public void addAccount(String username, Account account)
	{
		//First get the arraylist of associated accounts for a given user
		ArrayList<Account> temp = userAccounts.get(username);
				
		//If that arraylist is null (that user has no accounts yet) initialize it to a new arraylist
		if(temp == null)
			temp = new ArrayList<>();
		
		//add the given account to the list
		temp.add(account);
		
		//update the value at key of username with updated list of accounts
		userAccounts.put(username, temp);
	}
	
	public ArrayList<Account> getAccounts(String username)
	{
		return userAccounts.get(username);
	}
	
	public Set<String> getKeySet()
	{
		return this.userAccounts.keySet();
	}
}