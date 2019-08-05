package src.com.john.core;

import java.io.Serializable;
import java.util.ArrayList;

public class UserManager implements Serializable
{
	private static final long serialVersionUID = -1288174247227988513L;
	
	public ArrayList<User> users = new ArrayList<User>();
	
	public boolean addUser(String username, String password, int type)
	{
		if(this.doesUserExist(username))
			return false;
		
		User newUser = null;
		
		switch(type) {
		case 1:
			newUser = new Customer(username, password);
			break;
		case 2:
			newUser = new Employee(username, password);
			break;
		case 3:
			newUser = new Admin(username, password);
			break;
		}	
		
		this.addUser(newUser);
		
		return true;
	}
	
	void addUser(User u)
	{
		users.add(u);
	}
	
	public User getUser(String username)
	{
		for(User u : users)
		{
			if(u.getUsername().equals(username))
				return u;
		}
		
		return null;
	}
	
	public boolean doesUserExist(String username)
	{
		for(User u : users)
		{
			if(u.getUsername().equals(username))
				return true;
		}
		
		return false;
	}
	
	public boolean isCorrectCombination(String username, String password)
	{
		for(User u : users)
		{
			if(u.getUsername().equals(username))
				return u.getPassword().equals(password);
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		String str = "";
		
		for(User u : users)
		{
			if(u instanceof Employee && !(u instanceof Admin))
				str += "Employee - ";
			else if(u instanceof Admin)
				str += "Admin - ";
			else
				str += "Customer - ";
			str += u.getUsername() + "\n";
		}
		
		return str;
	}
}