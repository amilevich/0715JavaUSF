package com.bankdb.project.dao.implement;


import java.util.List;

import com.bankdb.project.dao.parameter.CreateNumberDAO;
import com.bankdb.project.dao.parameter.FindParameterById;
import com.bankdb.project.dao.parameter.UpdateParameterDao;
import com.bankdb.project.inteface.GeneralRepository;
import com.bankdb.project.model.ParametersDB;

public class ParametorDaoImpl implements GeneralRepository<ParametersDB> {
	FindParameterById findParameter = new FindParameterById();
	CreateNumberDAO crtNumber = new CreateNumberDAO();
	UpdateParameterDao update = new UpdateParameterDao();
	
	@Override
	public boolean createRegister(ParametersDB t) {
		crtNumber.createNum(t);
		return false;
	}
	@Override
	public List<ParametersDB> finAllRegister() {
		return null;
	}
	@Override
	public ParametersDB findById(ParametersDB t) {
		return findParameter.findParameterById(t);
	}
	@Override
	public boolean updateRegister(ParametersDB t) {
		return update.updateParameter(t);
	}
	@Override
	public boolean deleteRegister(ParametersDB t) {
		return false;
	}

	

}
