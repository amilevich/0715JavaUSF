package com.ers.project.model;

public class Email {
	
	private long eMailId;
	private String eFromEmail;
	private String ePassword;
	private String eSubject;
	private String eMessage;
	public long geteMailId() {
		return eMailId;
	}
	public void seteMailId(long eMailId) {
		this.eMailId = eMailId;
	}
	public String geteFromEmail() {
		return eFromEmail;
	}
	public void seteFromEmail(String eFromEmail) {
		this.eFromEmail = eFromEmail;
	}
	public String getePassword() {
		return ePassword;
	}
	public void setePassword(String ePassword) {
		this.ePassword = ePassword;
	}
	public String geteSubject() {
		return eSubject;
	}
	public void seteSubject(String eSubject) {
		this.eSubject = eSubject;
	}
	public String geteMessage() {
		return eMessage;
	}
	public void seteMessage(String eMessage) {
		this.eMessage = eMessage;
	}
	@Override
	public String toString() {
		return "Email [eMailId=" + eMailId + ", eFromEmail=" + eFromEmail + ", ePassword=" + ePassword + ", eSubject="
				+ eSubject + ", eMessage=" + eMessage + "]";
	}

}
