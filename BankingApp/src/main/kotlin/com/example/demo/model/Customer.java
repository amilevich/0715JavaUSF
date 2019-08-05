package com.example.demo.model;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Customer extends User implements Serializable
{
	private static final long serialVersionUID = 3L;

	private transient SimpleStringProperty firstname = new SimpleStringProperty("");
	
	private transient SimpleStringProperty lastname = new SimpleStringProperty("");
	
	private transient SimpleStringProperty address = new SimpleStringProperty("");
	
	private int customerID;
	
	public Customer()
	{
		super();
		this.customerID = 0;
	}

	@Override
	public SimpleStringProperty getUsername() {
		return this.username;
	}

	@Override
	public void setUsername(String username) {
		this.username.set(username);
	}

	public SimpleStringProperty getFirstname()
	{
		return firstname;
	}

	public void setFirstname(String firstname)
	{
		this.firstname.set(firstname);
	}

	public SimpleStringProperty getLastname()
	{
		return lastname;
	}

	public void setLastname(String lastname)
	{
		this.lastname.set(lastname);
	}

	public SimpleStringProperty getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address.set(address);
	}

	public int getCustomerID()
	{
		return customerID;
	}

	public void setCustomerID(int customerID)
	{
		this.customerID = customerID;
	}

	private void writeObject(ObjectOutputStream stream) throws IOException
	{
		stream.defaultWriteObject();
		stream.writeUTF(getFirstname().getValue());
		stream.writeUTF(getLastname().getValue());
		stream.writeUTF(getAddress().getValue());
		stream.writeUTF(getUsername().getValue());
	}

	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException
	{
		stream.defaultReadObject();
		this.firstname = new SimpleStringProperty(stream.readUTF());
		this.lastname = new SimpleStringProperty(stream.readUTF());
		this.address = new SimpleStringProperty(stream.readUTF());
		this.username = new SimpleStringProperty(stream.readUTF());
		// set values in the same order as writeObject()
	}
}
