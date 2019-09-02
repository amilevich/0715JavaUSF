package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.userroles.CreateUserRolesDAO;
import com.ers.project.dao.userroles.FindAllUserRolesDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.UserRoles;

public class UserRolesDAOImpl implements MainInterface<UserRoles>{
	
	@Override
	public boolean createRecord(UserRoles t) {
		return CreateUserRolesDAO.createUserRoles(t);
	}

	@Override
	public UserRoles findRecordById(UserRoles t) {
		return null;
	}

	@Override
	public List<UserRoles> findAllRecord() {
		return FindAllUserRolesDAO.findAll();
	}

	@Override
	public boolean updateRecord(UserRoles t) {
		return false;
	}

	@Override
	public boolean deleteRecord(UserRoles t) {
		return false;
	}

}
