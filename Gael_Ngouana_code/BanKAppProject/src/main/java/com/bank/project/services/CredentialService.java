package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.access.CreateCredentialDao;
import com.bank.project.dao.access.FindCredentByIdDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.CredentialCustumer;

public class CredentialService implements GeneralRepository<CredentialCustumer> {
	CreateCredentialDao crdCustomr = new CreateCredentialDao();
	FindCredentByIdDao findCredent = new FindCredentByIdDao();

	@Override
	public boolean createRegister(CredentialCustumer t) {
		return false; // crdCustomr.createCredentialCustomer(t);
	}

	@Override
	public List<CredentialCustumer> finAllRegister() {
		return null;
	}

	@Override
	public CredentialCustumer findById(CredentialCustumer t) {
		return null;// findCredent.findRegister(t);
	}

	@Override
	public boolean updateRegister(CredentialCustumer t) {
		return false;
	}

	@Override
	public boolean deleteRegister(CredentialCustumer t) {
		return false;
	}	

}
