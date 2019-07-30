package q7;

import java.util.Comparator;

//import q7.Comparator2.Employee;

//this is where the strings and int for name, dept, and age are declared

public class Employee {
	String name = new String();
	String dept = new String();
	int age;

	//this is the constructor for the employee class
	public Employee(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
	}
	
	
	//this formats how the strings print out
	public String toString() {
		return this.name + " \n" + this.dept + " \n" + this.age + " \n";

	}
}
	//this interface specifies how to sort the array by name
	class Sortbyname implements Comparator<Employee> {
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}
	//this interface specifies how to sort the array by dept
		class Sortbydept implements Comparator<Employee> {
			public int compare(Employee a, Employee b) {
				return a.dept.compareTo(b.dept);
			}
	}
		//this interface specifies how to sort the array by age
		class Sortbyage implements Comparator<Employee> {
			public int compare(Employee a, Employee b)
			{
				return a.age - b.age;
			}
		}

