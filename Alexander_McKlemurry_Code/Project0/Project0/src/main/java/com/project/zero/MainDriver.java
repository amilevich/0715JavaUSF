package com.project.zero;

import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class MainDriver {
	private static final Logger mora = Logger.getLogger(MainDriver.class);
	public static void main(String[] args) {
		ObjectStorage store = Load();
		if(store == null) {
			store = new ObjectStorage();
			InformationStorage eli = new InformationStorage();
			CustomerAccounts al = new CustomerAccounts();
			JointAccount joint = new JointAccount();
			store.addInformation(eli.getSSI1(), eli);
			store.addCustomer(al.getSSI(), al);
			store.addJoint("j", joint);
		}
		
		

		Mainmenu obj1 = new Mainmenu();
		obj1.showMenu(store);
		mora.info(" Main menu Entry " + "Access Point for Main Menu.");}
		
		
		public void Save(ObjectStorage store) {
			try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./nyarlathotep.txt"));
			oos.writeObject(store);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		public static ObjectStorage Load() {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./nyarlathotep.txt"));
				ObjectStorage store = (ObjectStorage)ois.readObject();
				return store;
				}catch(Exception e) {
					return null;
		}
			}
		
		Customer customerOne = new Customer("Alexander", "Mcklemurry", 67786, "Blade654", 67885, 9000);
		Customer customerTwo = new Customer("Elizabeth", "Mcklemurry", 54403, "Shadow747", 78896, 9000);
		
		CustomerDAOImple CDI = new CustomerDAOImple();
		//Customer.insertCustomer(customerOne);
		//Customer.insertCustomer(customerTwo);
		//UsersDatabase.insertCustomer(customerThree);
		
		
		//Customer cust1 = CDI.selectCustomerByName(customerOne.getfName());
		//System.out.println(cust1);
		//int cust2 =CDI.getBalance(customerTwo.getbalance());
		
		
	
		
		
		
		
//		System.out.println(UsersDatabase.selectAllCustomer());
//		System.out.println(UsersDatabase.selectCustomerByName("Alexander"));
//		customerOne.setName("Alex");
//		UsersDatabase.updateCustomer(customerOne);			//Update
//		System.out.println(UsersDatabase.selectCustomerByName("Alexander"));
//		
//		System.out.println(UsersDatabase.selectAllCustomer());
//		System.out.println(UsersDatabase.selectCustomerByName("Elizabeth"));
//		customerOne.setName("Eliza");
//		UsersDatabase.updateCustomer(customerOne);			//Update
//		System.out.println(UsersDatabase.selectCustomerByName("Elizabeth"));
		
		
	

}
