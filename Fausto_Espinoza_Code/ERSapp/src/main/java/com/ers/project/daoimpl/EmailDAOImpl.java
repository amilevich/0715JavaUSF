package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.mail.FindEmailDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.Email;

public class EmailDAOImpl implements MainInterface<Email> {

	@Override
	public boolean createRecord(Email t) {
		return false;
	}

	@Override
	public Email findRecordById(Email t) {
		return FindEmailDAO.findEmail(t);
	}

	@Override
	public List<Email> findAllRecord() {
		return null;
	}

	@Override
	public boolean updateRecord(Email t) {
		return false;
	}

	@Override
	public boolean deleteRecord(Email t) {
		return false;
	}

}
