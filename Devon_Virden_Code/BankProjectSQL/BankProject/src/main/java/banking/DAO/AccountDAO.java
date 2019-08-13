package banking.DAO;

import java.util.ArrayList;
import banking.application.Account;
import banking.application.User;

public interface AccountDAO {

	public void addAccount(Account account);

	public ArrayList<Account> getAllAccounts();

	public ArrayList<Account> getTiedAccounts(User user);

	public Account getAccount(int accountNumber);

	public void closeAccount(int accountNumber);

	public void updateAccount(Account account);
	
	public void tieAccount(Account account, User user);
	
	public boolean findAccount(int accountNumber);
	
	public boolean findPending();
	
	public boolean findPending(int accountNumber);
	
	public ArrayList<Account> viewPending();
	
	public int size();
	
	public boolean isTied(Account account, User user);
	
	public int retrieve();
}
