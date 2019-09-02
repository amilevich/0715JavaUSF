package com.revature.model;

public class ErsUsers {
	

	int ersUserId = 0; 

	String ersUserName = "";

	String ersPassword = "";

	String userFirstName = "";

	String userLastName = "";

	String userEmail = "";

	int userRoleId = 0;

	public int getErsUserId() {
		return ersUserId;
	}

	public void setErsUserId(int ersUserId) {
		this.ersUserId = ersUserId;
	}

	public String getErsUserName() {
		return ersUserName;
	}

	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public int getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(int userRoleId) {
		this.userRoleId = userRoleId;
	}

	@Override
	public String toString() {
		return "ErsReimbursement [ersUserId=" + ersUserId + ", ersUserName=" + ersUserName + ", ersPassword="
				+ ersPassword + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail="
				+ userEmail + ", userRoleId=" + userRoleId + "]";
	}

	public ErsUsers(int ersUserId, String ersUserName, String ersPassword, String userFirstName,
			String userLastName, String userEmail, int userRoleId) {
		super();
		this.ersUserId = ersUserId;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRoleId = userRoleId;
	}
	
	public ErsUsers() {
		
	}

	

}
