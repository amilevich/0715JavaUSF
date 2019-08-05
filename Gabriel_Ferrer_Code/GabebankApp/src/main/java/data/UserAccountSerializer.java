package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import model.Customer;

public class UserAccountSerializer {
	private static String filename = "src/main/useraccount.txt";

	public static void serialize(TreeMap<String, String> useraccounts) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(useraccounts);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	}

	public static TreeMap<String, String> deserialize() {
		TreeMap<String, String> useraccounts = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			useraccounts = (TreeMap<String, String>) inputStream.readObject();
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

		return useraccounts;
	}
}
