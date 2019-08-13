package com.project.zero;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	
String fname;
String lname;
int accnumber;
String passWord;
int id;
int balance;

	

	public Customer(String fname, String lname, int accnumber, String passWord, int id, int balance) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.accnumber = accnumber;
		this.passWord = passWord;
		this.id = id;
		this.balance = balance;
	}

	

	public String getfName() {
		return fname;
	}

	public void setfName(String name) {
		this.fname = name;
	}
	public String getlName() {
		return lname;
	}

	public void setlName(String name) {
		this.lname = name;
	}

	public  int getaccNumber() {
		return 67885;
	}

	public  void setaccNumber(int accnumber) {
		this.accnumber = accnumber;
	}
	@Override
	public String toString() {
		return "Customer [name=" + fname + ", accnumber=" + accnumber + "]";
	}
	public String  getpassWord() {
		
		return passWord;
	}
	public int getid() {
		
		return id;
	}


	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}



	public static void insertCustomer(Customer customerOne) {
		// TODO Auto-generated method stub
		
	}



	
}
