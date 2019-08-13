package com.revature.model;

public class Users {

int userId;
String username;
String password;
String firstName;
String lastName;
String role;
int type;

public Users() {
	
}

public Users(int userId, String username, String password, String firstName, String lastName, String role, int type) {
	super();
	this.userId = userId;
	this.username = username;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.role = role;
	this.type = type;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
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

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}

public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

@Override
public String toString() {
	return "Users [userId=" + userId + ", username=" + username + ", password=" + password + ", firstName=" + firstName
			+ ", lastName=" + lastName + ", role=" + role + ", type=" + type + "]";
}




}
