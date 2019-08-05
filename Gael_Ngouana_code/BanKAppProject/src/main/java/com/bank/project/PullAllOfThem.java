package com.bank.project;

import com.bank.project.inteface.PullDataBase;
import com.bank.project.services.PullDataBaseService;

public class PullAllOfThem {
	public static PullDataBase pullDataBase = new PullDataBaseService();
	
	public void pullAll() {
		pullDataBase.findAllAcounts();
		pullDataBase.findAllCustumers();
		pullDataBase.findAllEmployees();
		pullDataBase.findAllJointAccounts();
		pullDataBase.findAllTransaction();
	}

}
