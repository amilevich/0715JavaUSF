package com.qseven;
//make the class
public class Employee {
	public String name;
	public int age;
	public String department;
	public Employee(String name, int age, String department) {
		super();
		this.name = name;
		this.age = age;
		this.department = department;
		
	}
	//to make it human readable
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", department=" + department + "]";
	}
	
}
