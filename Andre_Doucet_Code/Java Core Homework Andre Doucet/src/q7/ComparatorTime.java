//Sort two employees based on their name, department, and age using the Comparator interface.

package q7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTime {

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
