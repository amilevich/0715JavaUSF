package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.account.JointAccountDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.JointAccount;

public class JointAccountService implements GeneralRepository<JointAccount> {
	public static JointAccountDao jaccount = new JointAccountDao();

	@Override
	public boolean createRegister(JointAccount t) {
		return jaccount.createJoint(t);
	}

	@Override
	public List<JointAccount> finAllRegister() {
		return null;
	}

	@Override
	public JointAccount findById(JointAccount t) {
		return null;
	}

	@Override
	public boolean updateRegister(JointAccount t) {
		return false;
	}

	@Override
	public boolean deleteRegister(JointAccount t) {
		return false;
	}

}
