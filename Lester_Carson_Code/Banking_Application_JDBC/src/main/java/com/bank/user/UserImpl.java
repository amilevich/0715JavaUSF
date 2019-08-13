package com.bank.user;

public class UserImpl {

	UserDAOImpl use = new UserDAOImpl();
	User user;

	public void Create(String name, String password) {
		use.insertUser(new User(name, password, 1));
		System.out.println("User created...");
	}
	
	public boolean Login(String name, String pass, int id, int input) {
		user = use.selectUserByUsernameAndPassword(name, pass, id, input);
		//statement for hard-coded employee and bank_admin. Function broke down for unknown reason
		if((user != null && user.getType() == id)) {
			return true;
		}
		System.out.println("Login in failed, incorrect username and/or password, or incorrect account type");
		return false;	
	}
}