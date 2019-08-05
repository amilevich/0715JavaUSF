package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeMap;

import model.BankAccount;
import model.Employee;

public class EmployeeSerializer {
	private static String filename = "src/main/employee.txt";
	
	public static void serialize(TreeMap<String, Employee> employees) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject( employees );

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}
	}

	public static TreeMap<String, Employee> deserialize() {
		TreeMap<String, Employee> employees = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			employees = (TreeMap<String, Employee>) inputStream.readObject();
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
		
		return employees;
	}
}
