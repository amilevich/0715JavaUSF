package bankapp;


	
	import java.io.FileNotFoundException;

//ApprovedApplication will parent DeniedApplication
    //DeniedApplication will parent.....

	//package com.test.project;

	//package items;

	import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import Menus.MainMenu;

	public class PendingApplication implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7812411237134521524L;
		static HashMap<String, Account> pendingApplication = new HashMap<String, Account>();
		private static Scanner sc = new Scanner(System.in);
		
		// methods for pending accounts hashmap
		
		public static void addAll(Object obj) {
			ArrayList<Object> pendingList = new ArrayList<Object>();
			pendingList.add(obj);
			
			for(Object object: pendingList) {
				Account cast = (Account) object;
				pendingApplication.put(cast.getUsername(), cast);
			}
	
			
			
			
//			pendingList.addAll((ArrayList<Account>) obj);
//			HashMap<String, Account>(HashMap<String, Account>) obj;
//			for(Entry<String, Account> en: obj.entrySet()) {
//				pendingApplication.put(en.getKey(), en.getValue());
//			}
			
		}
		
		public static final void deserialize() throws FileNotFoundException {
			System.out.println("Deserialization successful from pending.");
			ArrayList<Account> accounts = new ArrayList<Account>();
			accounts.add((Account)Login.readData("./pendingaccounts.txt"));
			addAll(accounts);
		}
		
//		public static void addAll(Object obj) {
//			ArrayList<Account> pendingList = new ArrayList<Account>();
//			pendingList.addAll((ArrayList<Account>) obj);
////			HashMap<String, Account>(HashMap<String, Account>) obj;
////			pendingApplication.putAll(obj);
//			
//		}
			public static void addOne(String username, Account account) {
				if(fetchOne(username)==null) {
					pendingApplication.put(username,account);
					Login.writeData(account, "pendingaccounts");
				}
				else {
					System.out.println("Username already in use.");
				}
			}
			
			public static ArrayList<Account> fetchAll(){
				ArrayList<Account> pendingList = new ArrayList<Account>();
				Set<String> keys = pendingApplication.keySet();
				for(String key: keys) {
					System.out.println(fetchOne(key).toString());
				}
				System.out.println("All Users");
				if(pendingApplication.isEmpty()) {
					System.out.println("No pending accounts.");
				}
				
				
				return pendingList;
			}
			public static Account fetchOne(String username) {
				Set<String> keys = pendingApplication.keySet();
				System.out.println("Username: " + username);
				Account account = null;
				for (String u: keys) {
					if(username.equals(u)) {
						System.out.println("Fetched");
						account = pendingApplication.get(u);
						
					}
					else {
//						System.out.println("No user found.");
					}
					}
				return account;
				
			}
			
			public static void removeOne(String username) {
				Set<String> keys = pendingApplication.keySet();
				Account a = fetchOne(username);
				if(a!=null) {
					
						pendingApplication.remove(a.getUsername());
						Login.updatePendingData(a);
					}
					else {
						System.out.println("Account not found.");
						MainMenu.mainMenu();
					}
				}
			
			public static Account createNewUser() {
				Account newAccount = null;
				System.out.println("Enter a username.");
//				sc.nextLine();
				String username = sc.nextLine();
				System.out.println("Enter a password.");
				String pw = sc.nextLine();
				System.out.println("Enter first name.");
				String firstname = sc.nextLine();
				System.out.println("Enter last name.");
				String lastname = sc.nextLine();
				System.out.println("Enter a balance");
				double balance = sc.nextDouble();
				System.out.println("Joint account? 1 for yes, 2 for no.");
				int joint = sc.nextInt();
				switch(joint) {
				case 1:
					System.out.println("Enter a second username");
					sc.nextLine();
					String username2 = sc.nextLine();
					newAccount = new Account(username,pw,balance,firstname,lastname,username2);
					addOne(username2, newAccount); //adds an extra duplicate account as value
					break;
				case 2:
					newAccount = new Account(username,pw,balance,firstname,lastname);
//					System.out.println(newAccount.toString());
					
				}
				addOne(username, newAccount);
				MainMenu.LoginMenu();
				return newAccount;
			}
			
			
			
	}