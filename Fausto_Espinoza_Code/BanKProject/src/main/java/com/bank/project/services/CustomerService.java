package com.bank.project.services;

import java.util.List;

import com.bank.project.dao.customer.CreateCustomerDao;
import com.bank.project.dao.customer.FindCustomerByIdDao;
import com.bank.project.dao.customer.UpdateCustomerDao;
import com.bank.project.inteface.GeneralRepository;
import com.bank.project.model.Customer;

public class CustomerService implements GeneralRepository<Customer> {

	CreateCustomerDao customerSystem = new CreateCustomerDao();
	FindCustomerByIdDao customerId = new FindCustomerByIdDao();
	UpdateCustomerDao updateCustomer = new UpdateCustomerDao();

	@Override
	public boolean createRegister(Customer t) {
		return customerSystem.createCustomer(t);
	}

	@Override
	public List<Customer> finAllRegister() {
		return null;
	}

	@Override
	public Customer findById(Customer t) {
		return customerId.findById(t);
	}

	@Override
	public boolean updateRegister(Customer t) {
		return updateCustomer.updateCustomer(t);
	}

	@Override
	public boolean deleteRegister(Customer t) {
		return false;
	}

}
