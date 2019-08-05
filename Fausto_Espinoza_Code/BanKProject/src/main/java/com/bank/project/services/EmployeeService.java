package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.customer.CreateEmployeeDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Employee;

public class EmployeeService implements GeneralRepository<Employee>{
	CreateEmployeeDao crtEmpl = new CreateEmployeeDao();
	

	@Override
	public boolean createRegister(Employee t) {
		return crtEmpl.createEmpl(t);
	}

	@Override
	public List<Employee> finAllRegister() {
		return null;
	}

	@Override
	public Employee findById(Employee t) {
		return null;
	}

	@Override
	public boolean updateRegister(Employee t) {
		return false;
	}

	@Override
	public boolean deleteRegister(Employee t) {
		return false;
	}

}
