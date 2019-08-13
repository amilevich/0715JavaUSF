package com.revature.model;

public class Userbank {
	
	
	
	String username = "";
	String password = "";
	int privilege = 0;
	
	
	
	
	
	public Userbank() {
		super();
	}
	
	public Userbank(String username, String password, int privilege) {
		super();
		this.username = username;
		this.password = password;
		this.privilege = privilege;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "Userbank [username=" + username + ", password=" + password + ", privilege=" + privilege + "]";
	}
	
	

}
