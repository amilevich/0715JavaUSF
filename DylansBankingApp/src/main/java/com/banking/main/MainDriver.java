package com.banking.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.banking.accounts.CustomerAccount;
import com.banking.dao.AccountAccess;
import com.banking.database.AccountDataBase;
import com.banking.database.PendingDataBase;
import com.banking.menus.MainMenu;

public class MainDriver implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4874318977248228987L;

	public static void main(String[] args) {

		//PendingDataBase.getPendingAccounts();
		//deserializeActive();
		//deserializePending();
		MainMenu menu= new MainMenu();
		
		//bellow is test data
		
		
		
		
		
		
		
		//above is test data
	}
	
	
	public static void deserializeActive() {
	HashMap<String, Object> map = AccountDataBase.getActiveAccounts();
    try
    {
       FileInputStream fis = new FileInputStream("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\DylansBankingApp\\src\\main\\java\\com\\banking\\database\\activehashmap.ser");
       ObjectInputStream ois = new ObjectInputStream(fis);
       map = (HashMap) ois.readObject();
       ois.close();
       fis.close();
    }catch(IOException ioe)
    {
       ioe.printStackTrace();
       return;
    }catch(ClassNotFoundException ac)
    {
       System.out.println("Class not found");
       ac.printStackTrace();
       return;
    }
    System.out.println("Deserialized HashMap..");
    // Display content using Iterator
    Set set = map.entrySet();
    Iterator iterator = set.iterator();
    while(iterator.hasNext()) {
       Map.Entry mentry = (Map.Entry)iterator.next();
       System.out.print("key: "+ mentry.getKey() + " & Value: ");
       System.out.println(mentry.getValue());
    }
	}
	
	public static void deserializePending() {
		
		HashMap<String, Object> map = PendingDataBase.getPendingAccounts();
	      try
	      {
	         FileInputStream fis = new FileInputStream("C:\\Users\\Dylan\\Documents\\Revature Bootcamp\\DylansBankingApp\\src\\main\\java\\com\\banking\\database\\pendinghashmap.ser");
	         ObjectInputStream ois = new ObjectInputStream(fis);
	         map = (HashMap) ois.readObject();
	         ois.close();
	         fis.close();
	      }catch(IOException pioe)
	      {
	         pioe.printStackTrace();
	         return;
	      }catch(ClassNotFoundException pc)
	      {
	         System.out.println("Class not found");
	         pc.printStackTrace();
	         return;
	      }
	      System.out.println("Deserialized HashMap..");
	      // Display content using Iterator
	      Set set = map.entrySet();
	      Iterator iterator = set.iterator();
	      while(iterator.hasNext()) {
	         Map.Entry mentry = (Map.Entry)iterator.next();
	         System.out.print("key: "+ mentry.getKey() + " & Value: ");
	         System.out.println(mentry.getValue());
	      }
		
	}
	
	

}
