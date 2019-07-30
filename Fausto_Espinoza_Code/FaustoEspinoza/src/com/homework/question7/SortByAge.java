package com.homework.question7;

import java.util.Comparator;

//Class sort by age implement Comparator

public class SortByAge implements Comparator<Employee> {

	@Override
	public int compare(Employee emp1, Employee emp2) {
		return emp1.getAge() - emp2.getAge();
	}

}
