package com.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp2 = new Employee("Rick", "Kitchen", 40); //instantiate two employees
		Employee emp1 = new Employee("Zack", "Electronics", 62);
		
		//add both employees to an ArrayList
		ArrayList<Employee> emps = new ArrayList<>();
		emps.add(emp1);
		emps.add(emp2);
		
		// print the unsorted list
		System.out.println("Before ");
		printArrList(emps);

		// print the list sorted by name.
		System.out.println("Sort by name.");
		Collections.sort(emps, new SortByName());
		printArrList(emps);
		System.out.println();
		
		// print the list sorted by age
		System.out.println("Sort by age");
		Collections.sort(emps, new SortByAge());
		printArrList(emps);
		System.out.println();
		
		//print the list sorted by department
		System.out.println("Sort by department");
		Collections.sort(emps, new SortByDepartment());
		printArrList(emps);
		
	}
	
	//method for printing an arraylist
	public static void printArrList(ArrayList<Employee> arrL) {
		for(Employee e: arrL) {
			System.out.println(e.toString());
		}
	}

}
