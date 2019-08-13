package main;

import java.util.TreeMap;
import java.util.TreeSet;

public class Form {
	public static TreeMap<Integer, String> data = new TreeMap<Integer, String>();
	public static TreeSet<String> users = new TreeSet<String>();
	static {
		createFormData();
	}
	
	public static void clearUsers() {
		users.clear();
	}
	
	public static Integer userCount() {
		return users.size();
	}
	
	public static boolean userTaken(String user) {
		return users.contains(user);
	}
	
	public static void addUsers(String user) {
		users.add(user);
	}
	
	public static TreeMap<Integer, String> createFormData() {
		for (Integer i = 1; i <= 72; i++) {
			data.put(i, "");
		}
		return data;
	}

	public static TreeMap<Integer, String> clearFormData() {
		for (Integer key : data.keySet()) {
			data.replace(key, "");
		}
		return data;
	}

	public static Integer getInt(Integer key) {

		return Integer.valueOf(data.get(key));
	}

	public static String getStr(Integer key) {

		return data.get(key);
	}

	public static Double getDbl(Integer key) {
		return Double.valueOf(data.get(key));
	}
	
	public static TreeMap<Integer, String> saveAnswer(Integer key, String str) {
		/// "1" - chosen value of option, "gabriel" or "222.12" - example value of field
		/// <2, "2"> /// user chose this option in the questiongroup number 1
		/// <8, "gabeferr"> /// user entered string in the username field
		/// <17, "200.67"> /// user entered amount in the Amount to Deposit (Amount with
		/// Two Decimals)
		data.put(key, str);

		return data;
	}
}
