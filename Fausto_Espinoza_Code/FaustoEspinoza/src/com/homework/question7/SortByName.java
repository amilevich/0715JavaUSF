package com.homework.question7;

import java.util.Comparator;

//Class sort by name implement Comparator

public class SortByName implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getName().compareTo(emp2.getName());
	}
	
	

}
