package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.users.CreateUsersDao;
import com.ers.project.dao.users.FindUserByEmailDAO;
import com.ers.project.dao.users.FindUserByIdDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.Users;

public class UserDAOImpl implements MainInterface<Users> {

	@Override
	public boolean createRecord(Users t) {
		return CreateUsersDao.createUsers(t);
	}

	@Override
	public Users findRecordById(Users t) {
		return FindUserByIdDAO.findById(t);
	}
	
	public Users findByEmail(Users t) {
		return FindUserByEmailDAO.findByEmail(t);
	}
	
	@Override
	public List<Users> findAllRecord() {
		return null;
	}

	@Override
	public boolean updateRecord(Users t) {
		return false;
	}

	@Override
	public boolean deleteRecord(Users t) {
		return false;
	}
	
	

}
