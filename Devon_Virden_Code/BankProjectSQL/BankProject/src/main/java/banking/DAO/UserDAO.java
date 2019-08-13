package banking.DAO;

import java.util.ArrayList;

import banking.application.Account;
import banking.application.User;

public interface UserDAO {
	
	public void addUser(User user);

	public ArrayList<User> getTiedUsers(Account account);

	public User getUser(String userid);

	public void updateUser(User user);
	
	public boolean findUser(String userid);

	public String getType(String userid);
	
	public int size();
	
	public int getCustomers();
}
