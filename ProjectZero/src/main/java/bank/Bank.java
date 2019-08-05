package bank;

import java.util.HashMap;
import org.apache.log4j.Logger;

import bank.Admin;
import bank.User;

public class Bank 
{
	
	protected final static Logger tracker = Logger.getLogger(Bank.class);
	
	public static HashMap<String, User> users = new HashMap<String,User>();
	private static Admin administrator;
	private static Employee emp;
	
	public static void main(String[] args) throws Exception 
	{
// After many failures...
		administrator = new Admin("Minqiu", "Yu");
		emp = new Employee("Employee", "Work");
		if(users != null)
		{
			User.load();
		}
		User customer = new User();
		while(true) 
		{
			customer.menu();
		}
	}
}
