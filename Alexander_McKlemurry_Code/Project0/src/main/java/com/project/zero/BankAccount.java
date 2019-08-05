package com.project.zero;

import java.util.Scanner;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BankAccount implements Serializable { 

	/**
	* 
	*/
	private static final long serialVersionUID = 8503899833102392937L;
	private static final Logger mora = Logger.getLogger(BankAccount.class);
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
		mora.info(" Main menu Entry " + "Access Point for Main Menu.");
			


	}
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
}
