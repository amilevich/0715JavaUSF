package com.homework;

public class Students {
	public String name;
	public String department;
	public int age;
	
	public Students(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age; 
		
	}
	
	public String toString() {
		return name + " " + department + " " + age;
		
	}
}
