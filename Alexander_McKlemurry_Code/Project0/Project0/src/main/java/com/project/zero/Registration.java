//package com.project.zero;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//
//
//public class Registration  {
//
//
//	
//	/**
//	 * 
//	 */
//	//private static final long serialVersionUID = -6904280273465292543L;
//	
//	
//	
//	
//	static String tempfName = "";
//	static String templName = "";
//	static String temppassword = "";
//	static String tempuserName = "";
//	static int tempaccountNumber = 0;
//	
//	
//
//public Registration(String fName1, String lName1, String password1, String tempfName, String templName, String temppassword, String tempuserName, int tempaccountNumber ) {
//		super();
//		this.tempfName = tempfName;
//		this.templName = templName;
//		this.temppassword = temppassword;
//		this.tempuserName = tempuserName;
//		this.tempaccountNumber = tempaccountNumber;
//		
//		
//	}
//
//
//
//
//public Registration(String string, String string2, String string3, String string4, int i) {
//		
//}
//
//
//
//
//public String gettempfName() {
//	return gettempfName();
//}
//
//
//
//public void settempfName(String fName) {
//	this.tempfName = fName;
//}
//
//
//
//public String getlName() {
//	return templName;
//}
//
//
//
//public void setlName(String lName) {
//	this.templName = lName;
//}
//
//
//
//public String getPassword() {
//	return temppassword;
//}
//
//
//
//public void setPassword(String password) {
//	this.temppassword = password;
//}
//
//
//
//public String getUsername() {
//	return tempuserName;
//}
//
//
//
//public void setUsername(String username) {
//	this.tempuserName = username;
//}
//
//
//
//public int getAccountNumber() {
//	return tempaccountNumber;
//}
//
//
//
//public void setAccountNumber(int accountNumber) {
//	this.tempaccountNumber = accountNumber;
//}
//
//
//
//public static void main(String[] args) {
//	
//	
//	System.out.println("Registrators");
//	Scanner sc = new Scanner(System.in);	
//
//	//data base
//	ArrayList<Registration> alist = new ArrayList<Registration>();
//	
//	alist.add( new Registration ("Elizabeth", "Mcklemurry","A54403", "Eliza", 78896 ));
//	alist.add( new Registration ("Alexander", "Mcklemurry","A67786", "Alex", 67885 ));
//	alist.add( new Registration("tempfName", "templName", "tempPassword", "tempUserName", tempaccountNumber));
//	
//	
//	for (int counter = 0; counter < alist.size(); counter++) { 		      
//        System.out.println(alist.get(counter).gettempfName());
//        System.out.println(alist.get(counter).getlName());
//        System.out.println(alist.get(counter).getPassword());
//        System.out.println(alist.get(counter).getUsername());
//        System.out.println(alist.get(counter).getAccountNumber());
//    }  
//	
//	System.out.println("firstName");
//	String input = sc.next();
//	tempfName = input;
//	
//	System.out.println("Lastname");
//	 input = sc.next();
//	templName = input;
//	
//	System.out.println("password");
//	 input = sc.next();
//	temppassword = input;
//	
//	System.out.println("user");
//	 input = sc.next();
//	tempuserName = input;
//	
//	System.out.println("account number");
//	int inputInt = sc.nextInt();
//	tempaccountNumber = inputInt;
//	
//	alist.add( new Registration (tempfName, templName,temppassword, tempuserName, tempaccountNumber  ));
//	
//	for (int counter = 0; counter < alist.size(); counter++) { 		      
//        System.out.println(alist.get(counter).gettempfName());
//        System.out.println(alist.get(counter).getlName());
//        System.out.println(alist.get(counter).getPassword());
//        System.out.println(alist.get(counter).getUsername());
//        System.out.println(alist.get(counter).getAccountNumber());
//    }  
//}			
//
//	
//	
//	
//	
//	
//}
