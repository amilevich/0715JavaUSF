package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CustomerAccounts  {

	
	
	/**
	 * 
	 */
	//private static final long serialVersionUID = -6858275704515685708L;
	private static final Logger mora = Logger.getLogger(CustomerAccounts.class);
	String str = "";
	String name = "Alexander";
	String password = "Blade654";
	String ssi ="67786";
	String acc = "67885";
	CustomerAccount a1 = new CustomerAccount();
	JointAccount h1 = new JointAccount();
	
	
	
	public CustomerAccounts(String str, String name, String password, String ssi, String acc, CustomerAccount a1,
			JointAccount h1) {
		super();
		this.str = str;
		this.name = name;
		this.password = password;
		this.ssi = ssi;
		this.acc = acc;
		this.a1 = a1;
		this.h1 = h1;
	}
	public CustomerAccounts() {
		
	}
	String getSSI() {
		return ssi;
	}
	String getName() {
		return name;
	}
	String getAcc() {
		return acc;
	}
	String getPassword() {
		return password;
		}
	CustomerAccount getAccount() {
		return a1;
	}
	public void showMenu(ObjectStorage store) {
		// TODO Auto-generated method stub
		
	}
	
}
