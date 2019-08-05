package com.banking.database;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

import com.banking.accounts.JointAccount;
import com.banking.accounts.CustomerAccount;
import com.banking.accounts.PendingAccount;
import com.banking.dao.AccountAccess;
import com.banking.menus.AdminMenu;
import com.banking.menus.EmployeeMenu;

public class PendingDataBase extends AccountAccess implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -720531355546080312L;
	
	private static HashMap<String, Object> pendingAccounts = new HashMap<>();
	
	

	public static HashMap<String, Object> getPendingAccounts() {
		return pendingAccounts;
	}

	public static void setPendingAccounts(HashMap<String, Object> pendingAccounts) {
		PendingDataBase.pendingAccounts = pendingAccounts;
	}

	public static Object getPendingAccount(String client) {
		return pendingAccounts.get(client);
	}

	public static void setPendingAccounts(Object client) {
		if(((PendingAccount) client).getStatus() == "pending") {
		pendingAccounts.put(((PendingAccount)client).getUsername(), client);
		
		//Serialization
		try {
			writeObject(getPendingAccounts());
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		//Serialization
	}else if(((JointAccount) client).getStatus() == "joint"){     
		pendingAccounts.put(((JointAccount) client).getJointAccess(), client);
		//Serialization
				try {
					writeObject(pendingAccounts);
				} catch (IOException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();
				}
				//Serialization
	}
	}
	

	
	public static void printAccounts() {
		if(pendingAccounts.isEmpty()==false) {
			System.out.println(pendingAccounts.keySet());
		}else {
		System.out.println(pendingAccounts.keySet());
		System.out.println("No pending accounts");
		EmployeeMenu.printMenu();
		}
	}
	
	public static Object viewAccount(String client) {
		return pendingAccounts.get(client).toString();
	}
	
	public static void deleteAccount(String client) {
		pendingAccounts.remove(client);
	}
	
	public static void pendingAccountApprovedToClientAccount(String client) {
		AccountDataBase.addAccount(client, pendingAccounts.get(client));
	}
	

	
	
	////ADMIN////
	
	public static void adminPrintAccounts() {
		if(pendingAccounts.isEmpty()) {
			System.out.println("No pending accounts");
			AdminMenu.printMenu();
		}else {
		System.out.println(pendingAccounts.keySet());
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void writeObject(HashMap<String, Object> activeAccounts) throws IOException {
		
		FileOutputStream fos = 
            new FileOutputStream("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\DylansBankingApp\\src\\main\\java\\com\\banking\\database\\pendinghashmap.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fos);
         oos.writeObject(activeAccounts);
         oos.close();
         fos.close();
         System.out.printf("Serialized HashMap data is saved in pendinghashmap.ser");
	}
	
	
	
	
	
	
	}
	
	

