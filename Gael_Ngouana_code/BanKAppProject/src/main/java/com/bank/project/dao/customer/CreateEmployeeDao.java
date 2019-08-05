package com.bank.project.dao.customer;

import com.bank.project.FileWriterTXT;
import com.bank.project.model.Employee;

public class CreateEmployeeDao {
	
	public boolean createEmpl(Employee empl) {
		FileWriterTXT<Employee> filename = new FileWriterTXT();
		return filename.writerFile(empl, "./DataBase/Employee.txt");
	}

}
