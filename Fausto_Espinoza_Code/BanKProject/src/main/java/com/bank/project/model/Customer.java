package com.bank.project.model;

import java.io.Serializable;

public class Customer extends Person implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2233971186101481780L;
	private String nmCustomer;
	private String address;
	private String phone;

	public String getNmCustomer() {
		return nmCustomer;
	}

	public void setNmCustomer(String nmCustomer) {
		this.nmCustomer = nmCustomer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [nmCustomer=" + nmCustomer + ", address=" + address + ", phone=" + phone + ", getId()="
				+ getId() + ", getUser()=" + getUser() + ", getPwd()=" + getPwd() + ", getKindPerson()="
				+ getKindPerson() + "]";
	}

	
	
	
}
