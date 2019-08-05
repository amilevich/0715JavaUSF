package com.bank.project.dao.customer;

import com.bank.project.MainEntry;
import com.bank.project.AdminManager.EmployeeMenu;
import com.bank.project.model.Employee;

public class FindEmployeeByUserDao {
	public Employee findEmpl(String user, String pwd) {		
		for(Employee a : EmployeeMenu.employee) {
			if(a.getPwd().equals(pwd) && a.getUser().equals(user)) {
				return a;
			}
		}
		
		return null;
	}
}
