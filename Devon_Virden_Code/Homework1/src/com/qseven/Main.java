package com.qseven;

import java.util.ArrayList;
import java.util.Collections;

//q7: Sort two employees based on Name, Department, Age.
public class Main {

	public static void main(String[] args) {
		System.out.println("Unsorted:");
		Employee emp1 = new Employee("Devon", 27, "Programming");
		Employee emp2 = new Employee("James", 24, "Administrative");
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(emp1);
		emp.add(emp2);
		printer(emp);
		// sort and print
		System.out.println("\nAge:");
		Collections.sort(emp, new AgeSort());
		printer(emp);
		System.out.println("\nName:");
		Collections.sort(emp, new NameSort());
		printer(emp);
		System.out.println("\nDepartment:");
		Collections.sort(emp, new DepartmentSort());
		printer(emp);
	}

	// to print them out
	static void printer(ArrayList<Employee> arr) {
		for (Employee i : arr) {
			System.out.println(i.toString());
		}
	}

}
