package com.qseven;
//compare by department
import java.util.Comparator;

public class DepartmentSort implements Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.department.compareTo(o2.department);
	}

}
