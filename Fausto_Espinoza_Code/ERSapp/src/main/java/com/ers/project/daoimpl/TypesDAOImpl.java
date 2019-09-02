package com.ers.project.daoimpl;

import java.util.List;

import com.ers.project.dao.types.CreateTypesDAO;
import com.ers.project.dao.types.FindAllTypesDAO;
import com.ers.project.interfaces.MainInterface;
import com.ers.project.model.ReimbursementTypes;

public class TypesDAOImpl implements MainInterface<ReimbursementTypes> {
	
	@Override
	public boolean createRecord(ReimbursementTypes t) {
		return CreateTypesDAO.createTypes(t);
	}

	@Override
	public ReimbursementTypes findRecordById(ReimbursementTypes t) {
		return null;
	}

	@Override
	public List<ReimbursementTypes> findAllRecord() {
		return FindAllTypesDAO.findAll();
	}

	@Override
	public boolean updateRecord(ReimbursementTypes t) {
		return false;
	}

	@Override
	public boolean deleteRecord(ReimbursementTypes t) {
		return false;
	}

}
