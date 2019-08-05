package com.project.zero;

import java.io.Serializable;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CustomerAccounts implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6858275704515685708L;
	private static final Logger mora = Logger.getLogger(CustomerAccounts.class);
	String str = "";
	String name = "Alexander";
	String password = "Blade654";
	String ssi ="A67786";
	String acc = "Xeno";
	CustomerAccount a1 = new CustomerAccount();
	JointAccount h1 = new JointAccount();
	
	
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
}
