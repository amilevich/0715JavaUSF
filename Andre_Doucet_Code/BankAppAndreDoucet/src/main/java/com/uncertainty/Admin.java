package com.uncertainty;

import java.io.Serializable;

public class Admin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2494762809670560946L;
	
	private String id;
	private String name;
	private String adminLogin;
	private String adminPassword;
	
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminLogin() {
		return adminLogin;
	}

	public void setAdminLogin(String adminLogin) {
		this.adminLogin = adminLogin;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", adminLogin=" + adminLogin + ", adminPassword=" + adminPassword
				+ "]";
	}
	
	

}
