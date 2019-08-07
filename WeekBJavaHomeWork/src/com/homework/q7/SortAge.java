package com.homework.q7;

import java.util.Comparator;

public class SortAge implements Comparator<Employee> {

	
	public int compare(Employee emp1, Employee emp2) {
		return emp1.age - emp2.age;
	}
}
