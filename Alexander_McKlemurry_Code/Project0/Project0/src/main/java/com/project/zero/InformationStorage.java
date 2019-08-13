package com.project.zero;

import java.io.Serializable; 
import java.util.Scanner;

import org.apache.log4j.Logger;

public class InformationStorage {
					
	/**
	 * 
	 */
	//private static final long serialVersionUID = -680266660836278314L;
	private static final Logger mora = Logger.getLogger(InformationStorage.class);
	String str = "";
	String name1 = "Elizabeth Mcklemury";
	String password1 = "Shade747";
	String ssi1 ="54403";
	String acc1 = "78896";
	BankAccounts b1 = new BankAccounts();
	JointAccount j1 = new JointAccount();
	
	String getSSI1() {
		return ssi1;
	}
	String getName1() {
		return name1;
	}
	String getAcc1() {
		return acc1;
	}
	String getPassword1() {
		return password1;
		}
	BankAccounts getAccounts() 
	{
		return b1;
	}
	JointAccount getJoint() {
		return j1;
	}
	public void showMenu(ObjectStorage store) {
		
		
	}
}
