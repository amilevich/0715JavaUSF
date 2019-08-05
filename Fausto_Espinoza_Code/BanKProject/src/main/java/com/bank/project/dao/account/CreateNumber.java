package com.bank.project.dao.account;

import com.bank.project.FileNumberTXT;
import com.bank.project.MainEntry;

public class CreateNumber {
	public boolean createNum(long number) {
		FileNumberTXT filename = new FileNumberTXT();		
		return filename.writerFile("./DataBase/numberAccount.txt", number);
	}

}
