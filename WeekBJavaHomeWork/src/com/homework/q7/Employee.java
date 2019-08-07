package com.homework.q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Employee {
	String name;
	int department;
	int age;
	
	

		public Employee(String name, int department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
		
	
		 @Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getDepartment() {
			return department;
		}


		public void setDepartment(int department) {
			this.department = department;
		}


		public int getAge() {
			return age;
		}


		public void setAge(int age) {
			this.age = age;
		}

		
		
	
		
		
		

}

 