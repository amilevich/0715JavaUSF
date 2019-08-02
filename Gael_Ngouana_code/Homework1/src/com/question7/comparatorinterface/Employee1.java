package com.question7.comparatorinterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Q7. Sort two employees based on their name, department, and age using the Comparator interface.


public class Employee1 {

	String name;
	String department;
	int age;

	//constructor
	Employee1(String name, String department, int age) {

		this.name = name;
		this.department = department;
		this.age = age;

	}

	public String toString() {
		return this.name + " " + this.department + " "+ this.age;
	}

}

class Sortbyname implements Comparator<Employee1> {

	//method that will sort by name
	@Override
	public int compare(Employee1 a, Employee1 b) {

		return a.name.compareTo(b.name);
	}
}

class Sortbydepartment implements Comparator<Employee1> {

	//method that will sort by department
	@Override
	public int compare(Employee1 a, Employee1 b) {

		return a.department.compareTo(b.department);
	}
}

class Sortbyage implements Comparator<Employee1> {

	//method that will sort by age
	@Override
	public int compare(Employee1 a, Employee1 b) {

		return a.age - b.age;
	}
}

	