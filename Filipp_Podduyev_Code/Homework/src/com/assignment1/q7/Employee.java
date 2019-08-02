package com.assignment1.q7;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {

	private String name;
	private String department;
	private int age;
	
	public static final Comparator<Employee> NameComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.name.compareTo(o2.name);
        }
      
    };
    
    public static final Comparator<Employee> DepComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.department.compareTo(o2.department);
        }
      
    };

	public static final Comparator<Employee> AgeComparator = new Comparator<Employee>(){

        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.age - o2.age;
        }
      
    };
    
	@Override
	public int compareTo(Employee o) {
		return 0;
	}

	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;

        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (this.department != other.department) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        return true;
    }

}

