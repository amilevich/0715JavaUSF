package com.bank.project;

import com.bank.project.inteface.PullDataBase;
import com.bank.project.services.PullDataBaseEnpl;

public class PullAllOfToEmpl {
	
public static PullDataBase pullDataBase = new PullDataBaseEnpl();
	
	public void pullAll() {
		pullDataBase.findAllAcounts();
		pullDataBase.findAllCustumers();
		pullDataBase.findAllEmployees();
		pullDataBase.findAllJointAccounts();
		pullDataBase.findAllTransaction();
	}

}
