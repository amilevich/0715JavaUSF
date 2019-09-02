package com.java.ers.dao;

/*
 * Interface to represent the RoleDao layer. 
 */
public interface RoleDao {

	/*
	 * Function to get the User Role based on the 
	 * id of the role. 
	 * 
	 * id - of the user role
	 * return user role of reimbursement
	 */
	public String getRole(int id);
	
	/*
	 * Function to fetch the id of the given User Role. 
	 * 
	 * role - of the user
	 * return id of the user role
	 */
	public int getRoleId(String role);
	
}
