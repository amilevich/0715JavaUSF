package src.com.john.core;

import java.io.Serializable;

public class Admin extends Employee implements Serializable
{
	private static final long serialVersionUID = -3106304571525634296L;

	public Admin(String username, String password)
	{
		super(username, password);
	}
}