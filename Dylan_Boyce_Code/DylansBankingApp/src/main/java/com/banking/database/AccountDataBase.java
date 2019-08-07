package com.banking.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import com.banking.accounts.CustomerAccount;
import com.banking.accounts.JointAccount;
import com.banking.accounts.PendingAccount;
import com.banking.menus.AdminMenu;
import com.banking.menus.EmployeeMenu;

public class AccountDataBase implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5185304426161322101L;
	
	
	private static HashMap<String,Object> activeAccounts = new HashMap<>();
	
	public static void addAccount(String clientName, Object approvedAccount) {
		getActiveAccounts().put(clientName, approvedAccount);
		try {
			writeObject(activeAccounts);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void setActiveAccount(Object client) {
		getActiveAccounts().put(((PendingAccount)client).getName(), client);
	}
	
	public static void printAccounts() {
		if(getActiveAccounts().isEmpty()) {
			System.out.println("No Active accounts....\n");
			EmployeeMenu.printMenu();
		}else {
		System.out.println(getActiveAccounts().keySet());
			}
	}
	
	public static Object viewAccount(String client) {
		return getActiveAccounts().get(client).toString();
	}
	
	public static Object getActiveAccount(String client) {
		return getActiveAccounts().get(client);
		
	}
	
	public static boolean validKey(String username) {
		return getActiveAccounts().containsKey(username);
	}
	
	public static String validJointKey(String username) {
		return ((PendingAccount) getActiveAccounts().get(username)).getJointAccess();
	}
	
	public static String validUserKey(String username) {
		return ((JointAccount) getActiveAccounts().get(username)).getUsername1();
	}
	
	
	public static void assignJointAccess(String username1, String username2) { //////JointAccess modifier
		((PendingAccount) getActiveAccounts().get(username1)).setJointAccess(username1+username2);
		((PendingAccount) getActiveAccounts().get(username2)).setJointAccess(username1+username2);
	}
	
	
	
				//////ADMIN////////
	
	public static void deleteAccount(String client) {
		getActiveAccounts().remove(client);
	}
	
	
	public static void adminPrintAccounts() {
		if(getActiveAccounts().isEmpty()) {
			System.out.println("No Active accounts....\n");
			AdminMenu.printMenu();
		}else {
		System.out.println(getActiveAccounts().keySet());
			}
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////

	public static void writeObject(HashMap<String, Object> activeAccounts) throws IOException {
	
		FileOutputStream fos = 
            new FileOutputStream("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\DylansBankingApp\\src\\main\\java\\com\\banking\\database\\activehashmap.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(activeAccounts);
         oos.close();
         fos.close();
         System.out.printf("Serialized HashMap data is saved in activehashmap.ser");
	}



	public static HashMap<String,Object> getActiveAccounts() {
		return activeAccounts;
	}



	public static void setActiveAccounts(HashMap<String,Object> activeAccounts) {
		AccountDataBase.activeAccounts = activeAccounts;
	}
   
   }

	
	

