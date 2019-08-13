package com.bank;

import com.dao.UserDaoImpl;

public class Employee extends User {
	/**
	 * @author JCampos storing Employees in HashMap
	 */
	private static final long serialVersionUID = 6529339495085000296L;
	
	public Employee() {
		userName = "username";
		password = "password";
		approved = true;
		joint = false;
		employee = true;
		admin = false;
		jointId = null;
		users.put("username", this);
	}
	
	public Employee(String name, String pass) {
		userName = name;
		password = pass;
		approved = true;
		joint = false;
		employee = true;
		admin = false;
		jointId = null;
		users.put(name, this);
	}
	
	public Employee(String s, String p, double b, int a, int j, int e, int ad, int aNum, String jId) {
		userName = s;
		password = p;
		balance = b;
		if(a==0)
			approved = false;
		else
			approved = true;
		if(j==0)
			joint = false;
		else
			joint = true;
		if(e==0)
			employee = false;
		else
			employee = true;
		if(ad==0)
			admin = false;
		else
			admin = true;
		acctNum = aNum;
		jointId = jId;
		//System.out.println("Welcome " + s + ", In constructor: load acct");
	}
		
	protected void approveAcct(String username) {
		//find acct and approve
		users.get(username).approved = true;
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		userDaoImpl.updateUser(users.get(username));
	}

}
