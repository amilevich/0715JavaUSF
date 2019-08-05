package model;

import java.io.Serializable;
import java.util.TreeMap;

public class UserAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4656843686782905017L;
	public static TreeMap<String, String> userAccounts = new TreeMap<String, String>();
	private static Integer counter = 0;
	

	public UserAccount(String username, String password) {
		userAccounts.put(username.toLowerCase(), password);
		++counter;
	}
	
	public UserAccount() {}

	public static void addUserAccounts(String username, String password) {
		userAccounts.put(username.toLowerCase(), password);
	}
	
	
	public static boolean exists(String username) {
		return userAccounts.containsKey(username);
	}
	
	public static boolean exists(String username, String password) {
		return exists(username) && userAccounts.get(username).equals( password );
	}

	public static TreeMap<String, String> getUserAccounts() {
		return userAccounts;
	}

	public static void setUserAccounts(TreeMap<String, String> userAccounts) {
		UserAccount.userAccounts = userAccounts;
	}
	
}
