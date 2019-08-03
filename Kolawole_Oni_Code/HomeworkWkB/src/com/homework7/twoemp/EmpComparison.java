package com.homework7.twoemp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmpComparison {
	 
	int age; 
    String name, department; 
    
    
    
	    public EmpComparison(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}



		public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getName() {
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



		@Override
	public String toString() {
		return "EmpComparison [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	

}
class SortbyAge implements Comparator<EmpComparison>{
	//Used to sort by age
	public int compare(EmpComparison a, EmpComparison b) {
		return a.name.compareTo(b.name);
	}
}
class Main {

public static void main(String []args) {
	ArrayList<EmpComparison> ar = new ArrayList<EmpComparison>();
	ar.add(new EmpComparison(102, "Benjamin", "Forensics" ));
	ar.add(new EmpComparison(110, "Noel", "Education" ));
	ar.add(new EmpComparison(120, "Luke", "Music" ));
	
	Collections.sort(ar, new SortbyAge());
	System.out.println("Sorted by Age");
	for(int i=0; i<ar.size(); i++)
		System.out.println(ar.get(i));
	
	
}
}