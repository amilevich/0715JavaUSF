package model;

import java.io.Serializable;
import java.util.TreeMap;
import java.util.TreeSet;


public class Employee extends Person implements Serializable {
	/**
	 * @author Gabriel Ferrer
	 */
	private static final long serialVersionUID = 8120370069845375678L;
	public static TreeMap<String, Employee> employees = new TreeMap<String, Employee>();
//	private String username;
	private Boolean isAdmin = false;
	private static Integer counter = 0;
	public Employee() {}
	
	public Employee (String firstName, String lastName, String username, String password, Boolean isAdmin) {
		super(firstName, lastName);
		this.isAdmin = isAdmin;
		employees.put(username, this);
		
		new UserAccount(username, password);
		++counter;
	}
	
	///static methods
	public static Integer getCounter() {
		return counter;
	}
	public static Employee getEmployee (String username) {
		return employees.get(username);
	}
	
	public static boolean isEmployee (String username) {
		return employees.containsKey(username);
	}
	
	public static boolean isAdmin (String username) {
		if (isEmployee(username)) {
			return getEmployee(username).isAdmin;
		}
		return false;
	}
	
	public static TreeMap<String, Employee> getAll() {
		return employees;
	}
	
	public static void setAll(TreeMap<String, Employee> e) {
		employees = e;
	}
	
	///object methods
	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	

	@Override
	public String toString() {
		return "Employee [ firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
