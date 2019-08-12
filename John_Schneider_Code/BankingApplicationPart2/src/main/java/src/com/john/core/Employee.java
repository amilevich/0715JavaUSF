package src.com.john.core;

import java.io.Serializable;

public class Employee extends User implements Serializable
{
	private static final long serialVersionUID = -7154144095283254687L;

	public Employee(String username, String password)
	{
		super(username, password);
	}
	
	//protected 
}