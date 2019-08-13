package main;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import model.*;

public class All {
	public static Application[] app = new Application[1];
	public static BankAccount[] ba = new BankAccount[1];
	public static Customer[] cust = new Customer[1];
	public static Employee[] em = new Employee[1];
	public static UserAccount[] ua = new UserAccount[1];
	
	public static TreeMap<Integer, Application> apps = new TreeMap<Integer, Application>();
	public static TreeMap<Integer, BankAccount> bas = new TreeMap<Integer, BankAccount>();
	public static TreeMap<String, Customer> custs = new TreeMap<String, Customer>();
	public static TreeMap<String, Employee> ems = new TreeMap<String, Employee>();
	
	public static Set<Integer> appss = new TreeSet<Integer>();
	public static Set<Integer> bass = new TreeSet<Integer>();
	public static Set<String> custss = new TreeSet<String>();
	public static Set<String> emss = new TreeSet<String>();
	public static Set<String> uass = new TreeSet<String>();
	
	public static String[] ah = {"Application Number", "Applicants", "Currency", "Account Sharing", "Amount"};
	public static String[] bh = {"Bank Account Number", "Account Holders", "Currency", "Account Sharing", "Amount"};
	public static String[] ch = {"Username", "Bank Account Numbers", "Firstname", "Lastname"};
	
}
