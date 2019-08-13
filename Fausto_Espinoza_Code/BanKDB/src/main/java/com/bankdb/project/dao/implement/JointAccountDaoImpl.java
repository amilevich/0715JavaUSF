package com.bankdb.project.dao.implement;

import java.util.List;

import com.bankdb.project.dao.account.FindJointAccountDao;
import com.bankdb.project.dao.account.JointAccountDao;
import com.bankdb.project.dao.account.UpdateJointAccountDao;
import com.bankdb.project.inteface.GeneralRepository;
import com.bankdb.project.model.JointAccount;
import com.bankdb.project.model.Person;

public class JointAccountDaoImpl implements GeneralRepository<JointAccount> {
	public static JointAccountDao jaccount = new JointAccountDao();
	public static UpdateJointAccountDao jUpdateAccount = new UpdateJointAccountDao();
	public static FindJointAccountDao findJAccount = new FindJointAccountDao();

	@Override
	public boolean createRegister(JointAccount t) {
		return jaccount.createJoint(t);
	}

	@Override
	public List<JointAccount> finAllRegister() {
		return null;
	}
	
	public List<JointAccount> finAllRegister(JointAccount acount, String status) {
		return null;
	}
		
	@Override
	public JointAccount findById(JointAccount t) {
		return null;
	}

	public List<JointAccount> findByIdCustomer(Person t ,String status) {
		return findJAccount.findJAccount(t, status);
	}
	
	@Override
	public boolean updateRegister(JointAccount t) {
		return false;
	}
	
	public boolean updateRegister(JointAccount t, String s) {
		return jUpdateAccount.updateJAcount(t, s);
	}

	@Override
	public boolean deleteRegister(JointAccount t) {
		return false;
	}

}
