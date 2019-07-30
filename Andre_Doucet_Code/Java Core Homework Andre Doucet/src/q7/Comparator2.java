package q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import q7.Comparator2.Employee;

public class Comparator2 {
	public void main(String[] args) {
		ArrayList<Employee> ar = new ArrayList<Employee>();
		ar.add(new Employee("Mario", "Plumber", 21));
		ar.add(new Employee("Luigi", "Plumber", 19));
		ar.add(new Employee("Toad", "Accountant", 35));

		//Collections.sort(ar, new Sortbyname());

		System.out.println("Sorted by name");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		System.out.println("Sorted by dept");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

		//Collections.sort(ar, new Sortbyage());

		System.out.println("Sorted by age");
		for (int i = 0; i < ar.size(); i++)
			System.out.println(ar.get(i));

	}

	class Employee {
		String name = new String();
		String dept = new String();
		int age;

		public Employee(String name, String dept, int age) {
			this.name = name;
			this.dept = dept;
			this.age = age;
		}

		public String toString() {
			return this.name + " \n" + this.dept + " \n" + this.age + " \n";

		}

		class Sortbyname implements Comparator<Employee> {
			public int compare(Employee a, Employee b) {
				return a.name.compareTo(b.name);
			}
			
			class Sortbydept implements Comparator<Employee> {
				public int compare(Employee a, Employee b) {
					return a.dept.compareTo(b.dept);
				}
		}
			
			class Sortbyage implements Comparator<Employee> {
				public int compare(Employee a, Employee b)
				{
					return a.age - b.age;
				}

	
			}
		}
	}
}

