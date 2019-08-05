package com.example.demo.model;

import javafx.beans.property.SimpleStringProperty;

public class User
{
	protected transient SimpleStringProperty username;
	
	protected transient SimpleStringProperty password;
	
	public User(String username, String password)
	{
		this.username = new SimpleStringProperty(username);
		this.password = new SimpleStringProperty(password);
	}

	public User()
	{
		this.username = new SimpleStringProperty("");
		this.password = new SimpleStringProperty("");
	}

	public SimpleStringProperty getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username.set(username);
	}

	public SimpleStringProperty getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password.set(password);
	}
}
