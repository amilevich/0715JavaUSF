package com.bank;

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
		users.put("username", this);
	}
	
	public Employee(String name, String pass) {
		userName = name;
		password = pass;
		approved = true;
		joint = false;
		employee = true;
		admin = false;
		users.put(name, this);
	}
		
	protected void approveAcct(String username) {
		//find acct and approve
		users.get(username).approved = true;
	}

}
