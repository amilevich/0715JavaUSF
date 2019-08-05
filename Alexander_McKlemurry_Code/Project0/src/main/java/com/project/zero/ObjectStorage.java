package com.project.zero;

import java.io.Serializable;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class ObjectStorage implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 2370109040849069813L;
	private static final Logger mora = Logger.getLogger(ObjectStorage.class);
	TreeMap<String, InformationStorage> storage = new TreeMap<String, InformationStorage>();
	TreeMap<String, InformationStorage> storage1 = new TreeMap<String, InformationStorage>();
	TreeMap<String, InformationStorage> storage2 = new TreeMap<String, InformationStorage>();
	TreeMap<String, CustomerAccounts> accounts = new TreeMap<String, CustomerAccounts>();
	TreeMap<String, CustomerAccounts> accounts1 = new TreeMap<String, CustomerAccounts>();
	TreeMap<String, CustomerAccounts> accounts2 = new TreeMap<String, CustomerAccounts>();
	TreeMap<String, JointAccount> jaccount = new TreeMap<String, JointAccount>();
	
	void addCustomer(String key, CustomerAccounts customer) {
		accounts.put(key, customer);
	}
	void addInformation(String key, InformationStorage customer) {
		storage.put(key, customer);
	}
	void addJoint(String key, JointAccount account) {
		jaccount.put(key, account);
	}
	JointAccount getAccount(String key) {
		return jaccount.get(key);
	}
	
	CustomerAccounts getCustomerSSI(String ssi) {
		return accounts.get(ssi);
	}
	CustomerAccounts get1CustomerName(String name) {
		return accounts.get(name);
	}
	CustomerAccounts get2CustomerAccount(String acc) {
		return accounts.get(acc);
	}
	InformationStorage get3CustomerSSI1(String ssi1) {
		return storage.get(ssi1);
	}
	InformationStorage get4CustomerName1(String name1) {
		return storage1.get(name1);
	}
	InformationStorage get5CustomerAccount1(String acc1) {
		return storage1.get(acc1);
	}
}
