package homework.question.q07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UsingComparator {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> employees = new ArrayList<>(); // create a store for all employees
		Employee gabe = new Employee("Gabriel", "Finance", 10); 
		Employee gabe2 = new Employee("Gabriel", "Marketing", 55);
		Employee ella = new Employee("Ella", "Sales", 32);
		Employee danny = new Employee("Danny", "Research", 10);
		Employee sean = new Employee("Sean", "Operations", 40);
		Employee luke = new Employee("Luke", "Admin", 25);
		
		//adds employees
		employees.add(gabe);
		employees.add(gabe2);
		employees.add(ella);
		employees.add(danny);
		employees.add(sean);
		employees.add(luke);
	
		System.out.println("Sorting by Name, Department and Age");
		//sorting using thenComparing chaining
		Collections.sort(employees, new EmployeeNameComparator()
									.thenComparing(new EmployeeDepartmentComparator())
									.thenComparing(new EmployeeAgeComparator()));
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
	}

	

}

class Employee {
	String name;
	String department;
	int age;
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	private Employee () {}
	@Override
	
	public String toString() {
		// TODO Auto-generated method stub
		return "[Name: " + name + " , Dept: " + department + " , Age: " + age + "]";
	}
	
	
}

class EmployeeNameComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.name.compareToIgnoreCase(e2.name);
	}
	
}

class EmployeeDepartmentComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.department.compareToIgnoreCase(e2.department);
	}
	
}

class EmployeeAgeComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		// TODO Auto-generated method stub
		return e1.age > e2.age ? -1 : 1;
	}
	
}