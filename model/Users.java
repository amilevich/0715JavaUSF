package com.project1.model;

public class Users {
	
	int usersID;
	String username;
	String password;
	String firstname;
	String lastname;
	String email;
	int usersRoleID;
	String usersRole;
	
	public Users() {
		
	}
	
	
	
	

	public Users(String username, String password, String usersRole) {
	super();
	this.username = username;
	this.password = password;
	this.usersRole = usersRole;
}


	public Users(int usersID, String username, String password, String firstname, String lastname, String email,
			int usersRoleID, String usersRole) {
		super();
		this.usersID = usersID;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.usersRoleID = usersRoleID;
		this.usersRole = usersRole;
	}




	public int getUsersID() {
		return usersID;
	}

	public void setUsersID(int usersID) {
		this.usersID = usersID;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUsersRoleID() {
		return usersRoleID;
	}

	public void setUsersRoleID(int usersRoleID) {
		this.usersRoleID = usersRoleID;
	}

	public String getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(String usersRole) {
		this.usersRole = usersRole;
	}

	@Override
	public String toString() {
		return "Users [usersID=" + usersID + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", usersRoleID=" + usersRoleID
				+ ", usersRole=" + usersRole + "]";
	}
	
	

}
