package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

import org.apache.log4j.Logger;

public class Application implements Serializable {
	
	/**
	 * @author Gabriel Ferrer
	 */
	private static final long serialVersionUID = 4101834868890954424L;
	final static Logger logger = Logger.getLogger(Application.class);
	public static TreeMap<Integer, Application> applications = new TreeMap<Integer, Application>();
	private static Integer counter = 0;
	private Integer number;
	private ArrayList<Applicant> applicants = new ArrayList<Applicant>();
	private AccountDetail accountDetail;
	
	///constructors
	
	public Application(ArrayList<Applicant> applicants, AccountDetail accountDetail) {
		this.number = ++counter;
		this.applicants = applicants;
		this.accountDetail = accountDetail;
		applications.put(counter,this);
		logger.info(String.format("Application number %1$s was created for %2$s account", this.number, 
				this.accountDetail.accountSharing.toString()));
	}

	public Application() {
		// TODO Auto-generated constructor stub
	}
	
	//// object methods
	public String getApplicantNames() {
		StringBuilder names = new StringBuilder();
		for(Applicant app: applicants) {
			names.append(app.firstName + " ");
			names.append(app.lastName + ", ");
		}
		
		return names.toString();
	}

	public void setApplicants(ArrayList<Applicant> applicants) {
		this.applicants = applicants;
	}

	public AccountDetail getAccountDetail() {
		return accountDetail;
	}

	public void setAccountDetail(AccountDetail accountDetail) {
		this.accountDetail = accountDetail;
	}

	@Override
	public String toString() {
		return "Application [applicants=" + applicants + ", accountDetail=" + accountDetail + "]";
	}
	
	////////////////static methods
	
	public static Integer getCounter() {
		return counter;
	}
	
	public static void setCounter(Integer n) {
		counter = n;
	}
	
	public static TreeMap<Integer, Application> getAll() {
		return applications;
	}
	
	public static void setAll(TreeMap<Integer, Application> apps) {
		applications = apps;
	}
	
	public static Application getOne(Integer i) {
		return applications.get(i);
	}
	
	public static Integer getSize() {
		return applications.size();
	}
	
	public static Set<Integer> getNumbers() {
		return applications.keySet();
	}
	
	public static boolean exists(Integer reference) {
		return applications.containsKey(reference);
	}
	
	public static void approve(Integer id) {
		BankAccount newBankAccount = new BankAccount(  applications.get(id).accountDetail.amount, 
				applications.get(id).accountDetail.currency,
				applications.get(id).accountDetail.accountSharing);
		
		for(Applicant applicant: applications.get(id).applicants) {
			new Customer(applicant.firstName, applicant.lastName, applicant.username, newBankAccount.getNumber());
			new UserAccount(applicant.username, applicant.password);
		}
		logger.info(String.format("Application number %1$s was approved", id));
	
		applications.remove(id);
	}
	
	public static void deny(Integer id) {
		applications.remove(id);
		logger.info(String.format("Application number %1$s was rejected", id));
	}
	
	
	
	
}

