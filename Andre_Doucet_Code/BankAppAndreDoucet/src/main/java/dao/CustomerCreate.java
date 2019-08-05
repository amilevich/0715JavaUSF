package dao;

import com.drivers.DataDBDriver;
import com.mainmenu.MainScreen;
import com.uncertainty.Customer;

public class CustomerCreate {
public boolean addtoDB(Customer customer) {
	String filename = "./customer.txt";
	DataDBDriver<Customer> driveDB = new DataDBDriver<>();
	return driveDB.writerFile(customer, filename);
	
}
}
