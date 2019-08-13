package com.bankdb.project.model;


public class Person {

	private String user;
	private String pwd;
	private String nmPerson;
	private String address;
	private String phone;
	private String KindPerson;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNmPerson() {
		return nmPerson;
	}
	public void setNmPerson(String nmPerson) {
		this.nmPerson = nmPerson;
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
	public String getKindPerson() {
		return KindPerson;
	}
	public void setKindPerson(String kindPerson) {
		KindPerson = kindPerson;
	}
	@Override
	public String toString() {
		return "Person [user=" + user + ", pwd=" + pwd + ", nmPerson=" + nmPerson + ", address=" + address + ", phone="
				+ phone + ", KindPerson=" + KindPerson + "]";
	}
	
	
}
