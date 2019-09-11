package com.example.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	private int id;
	private String name;
	private String mobile;
	private String address;
	private String companyLogo;
	
	public Employee() {
	}

	public Employee(int id, String name, String mobile, String address, String companyLogo) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.address = address;
		this.companyLogo = companyLogo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", mobile=" + mobile + ", address=" + address
				+ ", companyLogo=" + companyLogo + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

}
