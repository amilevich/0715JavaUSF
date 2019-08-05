package com.uncertainty;

import java.io.Serializable;

public class Customer implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3480111099277034803L;
	private String id;
	private String name;
	private String address;
	private String telephonenumber;
	private String username;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephonenumber() {
		return telephonenumber;
	}
	public void setTelephonenumber(String telephonenumber) {
		this.telephonenumber = telephonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", telephonenumber=" + telephonenumber
				+ ", username=" + username + ", password=" + password + "]";
	}
		
	 

}
