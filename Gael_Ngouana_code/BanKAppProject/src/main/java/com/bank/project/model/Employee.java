package com.bank.project.model;

import java.io.Serializable;

public class Employee extends Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 55770748522855481L;
	private String nmCustomer;

	public String getNmCustomer() {
		return nmCustomer;
	}

	public void setNmCustomer(String nmCustomer) {
		this.nmCustomer = nmCustomer;
	}

	@Override
	public String toString() {
		return "Employee [nmCustomer=" + nmCustomer + "]";
	}
	
	

}
