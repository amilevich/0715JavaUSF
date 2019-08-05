package dao;

import com.drivers.DataDBDriver;
import com.mainmenu.MainScreen;
import com.uncertainty.Employee;

public class EmployeeCreate {
public boolean addtoDB(Employee employee) {
	String filename = "./employee.txt";
	DataDBDriver<Employee> driveDB = new DataDBDriver<>();
	return driveDB.writerFile(employee, filename);
	
}
}
