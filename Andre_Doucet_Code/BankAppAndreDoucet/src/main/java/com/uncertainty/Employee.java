package com.uncertainty;

import java.io.Serializable;

public class Employee implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2300243597776603198L;
	
	private String employeeLogin;
	private String employeePassword;
	private String employeeName;
	private String id;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeLogin() {
		return employeeLogin;
	}

	public void setEmployeeLogin(String employeeLogin) {
		this.employeeLogin = employeeLogin;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	@SuppressWarnings("unused")
	private String getId() {
		return id;
	}

	
	@Override
	public String toString() {
		return "Employee [employeeLogin=" + employeeLogin + ", employeePassword=" + employeePassword + ", employeeName="
				+ employeeName + ", id=" + id + "]";
	}
}
