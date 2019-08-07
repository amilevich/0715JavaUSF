package com.homework.q7;

import java.util.Comparator;

public class SortDepartment  implements Comparator<Employee> {

	
	public int compare(Employee emp1, Employee emp2) {
		return emp1.department - (emp2.department);
	}
}
