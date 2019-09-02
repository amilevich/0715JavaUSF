package com.ers.project.model;

public class UserRoles {
	private long roleId;
	private String roleName;
	
	
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "UserRoles [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	
	

}
