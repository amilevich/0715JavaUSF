package com.bank.project.dao.account;

import com.bank.project.FileWriterTXT;
import com.bank.project.model.JointAccount;

public class JointAccountDao {
	
	public boolean createJoint(JointAccount jacount) {
		FileWriterTXT<JointAccount> filename = new FileWriterTXT();
		return filename.writerFile(jacount, "./DataBase/JointAccount.txt");
	}

}
