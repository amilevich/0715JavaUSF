package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

import model.Application;
import model.BankAccount;

public class BankAccountSerializer {
	private static String filename = "src/main/bankaccount.txt";
	
	public static void serialize(TreeMap<Integer, BankAccount> bankaccounts) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(bankaccounts);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	}

	public static TreeMap<Integer, BankAccount> deserialize() {
		TreeMap<Integer, BankAccount> bankaccounts = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			bankaccounts = (TreeMap<Integer, BankAccount>) inputStream.readObject();
			fileInputStream.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			// TODO Auto-generated catch block
			cnf.printStackTrace();
		}
		
		return bankaccounts;
	}
}
