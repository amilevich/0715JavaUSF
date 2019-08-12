package com.bank.user;

public class UserImpl {

	UserDAOImpl use = new UserDAOImpl();
	User user;

	public void Create(String name, String password) {
		use.insertUser(new User(name, password, 1));
		System.out.println("User created...");
	}
	
	public boolean Login(String name, String pass, int input, int id) {
		user = use.selectUserByUsernameAndPassword(name, pass, input, id);
		if(user != null) {
			return true;
		}
		System.out.println("Login in failed, incorrect username and/or password...");
		return false;	
	}
}