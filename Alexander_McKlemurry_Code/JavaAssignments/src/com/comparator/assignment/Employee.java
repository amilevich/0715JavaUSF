package com.comparator.assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {

	String name;
	String department;
	int age;

	public Employee(String name, String department, int age) { //Class and giving my variables a name
		super();			//"super" class often implicit when using "this"
		this.name = name;
		this.department = department;
		this.age = age;

	}

	public String toString() {
		return this.name + " " + this.department + " " + this.age; // telling the system to return these
		//values. This needs to be done as there is no "void"
	}

	public static void main(String[] args) {		//main method
		ArrayList<Employee> employeelist = new ArrayList<Employee>();	//creating an arraylist and
		//giving it an associate name
		
		employeelist.add(new Employee("Eliza", "HR", 32));	//creating employees within the list
		employeelist.add(new Employee("Alex", "Math", 21)); //and giving the employee needed parameters
		
		System.out.println("SortName"); //giving the output results a name
		Collections.sort(employeelist, new SortName()); // pulling form the collection API
		
		for(int i = 0; i < employeelist.size(); i++) { //a normal for loop that is catered to an
			//arraylist via the (.)operator and size
			System.out.println(employeelist.get(i));	
		}
		
		System.out.println("SortDepartment"); // same as above for employee
		Collections.sort(employeelist, new SortDepartment());// same as above for employee
		
		for(int i = 0; i < employeelist.size(); i++) { // for loop used to ensure that sortdepartment
			System.out.println(employeelist.get(i));	//and sort age
		}
		
		System.out.println("SortAge");
		Collections.sort(employeelist, new SortAge()); //same purpose as above
		
		for(int i = 0; i < employeelist.size(); i++) {
			System.out.println(employeelist.get(i));
		}
	}
	
}


		class SortName implements Comparator<Employee> {  //This and the ones below are the made classes
			public int compare(Employee y, Employee z) { // To tell the system to compare employee y
				return y.name.compareTo(z.name);// with employee z and return the value of their name
						
			}
		}
		
		
		
		class SortDepartment implements Comparator<Employee> { //Same as before except by department
			public int compare(Employee y, Employee z) {
				return y.department.compareTo(z.department);
						
			}
		}
		
		
		class SortAge implements Comparator<Employee> {		//same as before except with age
			public int compare(Employee y, Employee z) {	// but there are some slight differences
				return y.age - z.age;		//there is no compare here due to this being pulled
				//form an integer instead of a string
						
			}
		}
