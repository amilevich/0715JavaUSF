package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.status.CreateStatusDAO;
import com.ers.project.dao.status.FindAllStatusDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.ReimbursementStatus;

public class StatusDAOImpl implements MainInterface<ReimbursementStatus> {
	@Override
	public boolean createRecord(ReimbursementStatus t) {
		return CreateStatusDAO.createStatus(t);
	}

	@Override
	public ReimbursementStatus findRecordById(ReimbursementStatus t) {
		return null;
	}

	@Override
	public List<ReimbursementStatus> findAllRecord() {
		return FindAllStatusDAO.findAll();
	}

	@Override
	public boolean updateRecord(ReimbursementStatus t) {
		return false;
	}

	@Override
	public boolean deleteRecord(ReimbursementStatus t) {
		return false;
	}

}
