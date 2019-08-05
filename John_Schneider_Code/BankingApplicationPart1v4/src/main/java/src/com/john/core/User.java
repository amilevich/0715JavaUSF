package src.com.john.core;

import java.io.Serializable;

public abstract class User implements Serializable
{

	private static final long serialVersionUID = 7897235796166939792L;
	
	private String username;
	private String password;
	
	public User(String username, String password)
	{
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}
	void setUsername(String username) {
		this.username = username;
	}

	String getPassword() {
		return password;
	}
	void setPassword(String password) {
		this.password = password;
	}
}