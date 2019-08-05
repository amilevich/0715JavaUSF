package com.bank.project.model;

import java.io.Serializable;

public class JointAccount extends Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428047670303252104L;
	private String accountNumber;
	private String idCustomer;
	private char status;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "JointAccount [accountNumber=" + accountNumber + ", idCustomer=" + idCustomer + ", status=" + status
				+ "]";
	}
	
	
	

}
