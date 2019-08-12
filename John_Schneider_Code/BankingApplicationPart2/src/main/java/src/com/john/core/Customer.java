package src.com.john.core;

import java.io.Serializable;

public class Customer extends User implements Serializable
{
	private static final long serialVersionUID = 3399204442182582649L;

	public Customer(String username, String password)
	{
		super(username, password);
	}
}