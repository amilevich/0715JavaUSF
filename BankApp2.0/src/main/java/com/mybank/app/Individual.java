package com.mybank.app;

public class Individual {
	
	String username;
	String password;
	String first_name;
	String last_name;
	int type;
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
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Individual [username=" + username + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", type=" + type + "]";
	}
	
	
	
	
	
	

}
