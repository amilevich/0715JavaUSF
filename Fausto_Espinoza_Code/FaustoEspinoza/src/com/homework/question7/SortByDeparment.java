package com.homework.question7;

import java.util.Comparator;

//Class sort by department implement Comparator

public class SortByDeparment implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getDepartment().compareTo(emp2.getDepartment());
	}

}
