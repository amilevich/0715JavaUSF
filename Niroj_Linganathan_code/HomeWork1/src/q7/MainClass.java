package q7;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		ArrayList<employee> array = new ArrayList<employee>();
		array.add(new employee(50, "Kumaran", "IT"));
		array.add(new employee(40, "Murugan", "Finance"));

		System.out.println("Unsorted Order:");
		System.out.println("----------------");
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i));

		}
		Collections.sort(array, new sortbyage());
		System.out.println();
		System.out.println("Ordered by age:");
		System.out.println("----------------");
		for (int a = 0; a < array.size(); a++) {
			System.out.println(array.get(a));
		}
		
		Collections.sort(array,new sortbyname());
		System.out.println();
		System.out.println("Ordered by Name:");
		System.out.println("----------------");
		for (int a = 0; a < array.size(); a++) {
			System.out.println(array.get(a));
		}
		
		Collections.sort(array,new sortbydepartment());
		System.out.println();
		System.out.println("Ordered by Department:");
		System.out.println("----------------");
		for (int a = 0; a < array.size(); a++) {
			System.out.println(array.get(a));
		}
	}
}

class employee {
	int age;
	String name, department;

	public employee(int age, String name, String department) {
		super();
		this.age = age;
		this.name = name;
		this.department = department;
	}

	public String toString() {
		return this.name + " " + this.department + " " + this.age;

	}
}

class sortbyage implements Comparator<employee> {

	@Override
	public int compare(employee o1, employee o2) {

		return o1.age - o2.age;

	}

}

class sortbyname implements Comparator<employee> {

	@Override
	public int compare(employee o1, employee o2) {

		return o1.name.compareTo(o2.name);
	}

}

class sortbydepartment implements Comparator<employee>{

	@Override
	public int compare(employee o1, employee o2) {
		
		return o1.department.compareTo(o2.department);
	}
	
}
