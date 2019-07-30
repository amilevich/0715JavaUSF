package com.homework.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class QuestionSeven
{
	/*
	 * Sort two employees based on name, department, and age using comparator interface
	 */
	
	//Driver class
	//Creates employee objects, stores them in an arraylist, sorts that arraylist per guidlines of implemented comparator
	
	public static void main(String[] args)
	{
		//Create two employee objects with same first name, different department, and same age
		Employee eOne = new Employee("John","Z",23);
		Employee eTwo = new Employee("John","A",23);
		
		//Create arraylist and store employee objects in it
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(eOne);
		employees.add(eTwo);
		
		//Print out the unsorted list of employees
		System.out.println("Unsorted Employees: ");
		for(Employee e : employees)
		{
			System.out.println(e);
		}
		
		//Utilize the sort method of the collections class to sort given collection by given comparator
		//collection used is arraylist employees and the employeecomparer comparator
		Collections.sort(employees, new EmployeeComparer());
		
		//Print out the sorted list of employees
		System.out.println("Sorted Employees: ");
		for(Employee e : employees)
		{
			System.out.println(e);
		}
	}
}

//Define an implementation of Comparator for use specificially on Employee type objects
class EmployeeComparer implements Comparator<Employee>
{
	//Implement the necessary compare(...) method from comparator
	@Override
	public int compare(Employee o1, Employee o2) {
		int n, d, a; //varaibles to hold comparsion results between the string and int fields of the given employees
		
		n = o1.name.compareToIgnoreCase(o2.name); //Utilizes String's compareToIgnoreCase() method. Returns negative value if o1 is less than o2, zero if they are equal, positive if o1 is greater than o2
		d = o1.department.compareToIgnoreCase(o2.department);//Same utilization as above line however with department strings as opposed to name
		a = o1.age - o2.age; //Compares ages simply by subtracting o1's from o2's -> a will be negative if o2 is bigger, 0 if they are equal, and positive if o1 is bigger
		
		//Order will be determined by comparison of name, department, then age
		//Ordered by if name is greater or smaller, if not then if department is greater or smaller, if not then if age is greater or smaller
		if(n != 0) return n; //if name is not equal return status as greater (positive value) or smaller (negative value)
		else if(d != 0) return d; //if department is not equal return status as greater (positive value) or smaller (negative value)
		else return a; //otherwise return if age is greater, smaller, or equal
	}
}

//Employee class for use in making employee objects
class Employee
{
	//Employee's have name, department, and age fields
	String name, department;
	int age;
	
	//Constructor to initialize fields with given arguments
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//Overrides Object's toString to return String of information relevant to Employee objects
	@Override
	public String toString()
	{
		return name+", "+department+", "+age;
	}
}