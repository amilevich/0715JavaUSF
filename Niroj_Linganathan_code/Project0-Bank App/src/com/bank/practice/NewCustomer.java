package com.bank.practice;

import java.io.Serializable;
import java.util.Date;

public class NewCustomer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String String = null;
	
	private String userName;
	private String password;
	private String CFirstName;
	private String CLastName;
	private String DOB;
	private String address;
	private String phone;
	private String SSN;
	
	

	private String accNumber;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public NewCustomer(String userName, String password, String cFirstName, String cLastName, String dOB,
			String address, String phone, String sSN, java.lang.String accNumber) {
		super();
		this.userName = userName;
		this.password = password;
		CFirstName = cFirstName;
		CLastName = cLastName;
		DOB = dOB;
		this.address = address;
		this.phone = phone;
		SSN = sSN;
		this.accNumber = accNumber;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCFirstName() {
		return CFirstName;
	}

	public void setCFirstName(String cFirstName) {
		CFirstName = cFirstName;
	}

	public String getCLastName() {
		return CLastName;
	}

	public void setCLastName(String cLastName) {
		CLastName = cLastName;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(String accNumber) {
		this.accNumber = accNumber;
	}

	@Override
	public String toString() {
		return accNumber;
	}

	public NewCustomer(String accNumber) {
		super();
		this.accNumber = accNumber;
	}

	public NewCustomer() {
		super();
	}

	
	}

	
	



	

	

