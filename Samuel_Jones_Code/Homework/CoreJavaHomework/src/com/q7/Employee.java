package com.q7;

import java.util.Comparator;

public class Employee {
	private String name; //fields 
	private String department;
	private Integer age;
	
	public Employee(String name, String department, Integer age) { //constructor for creating employees
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName() { //getters and setters
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	//toString method
	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	
}

//method for sorting based on the comparator interface.
class SortByName implements Comparator<Employee> { // sort employees by name.
	public int compare(Employee one, Employee two) { 
		return one.getName().compareTo(two.getName());
	}
}
class SortByDepartment implements Comparator<Employee>{ //sort employees by department
	public int compare(Employee one, Employee two) {
		return one.getDepartment().compareTo(two.getDepartment());
	}
}
class SortByAge implements Comparator<Employee>{ //sort employees by age
	public int compare(Employee one, Employee two) {
		return one.getAge() - two.getAge();
	}
}


