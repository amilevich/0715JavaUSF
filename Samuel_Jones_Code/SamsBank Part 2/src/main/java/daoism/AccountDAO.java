package daoism;

import java.util.List;

import items.Account;

public interface AccountDAO {
	public int insertAccount(Account a);
	public Account selectAccountByUsername(String username);
	public List<Account> selectAllAccounts();
	public int updateAccount(Account a);
	public int deleteAccount(Account a);
}
