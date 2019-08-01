package q7.compare.it;

import java.util.ArrayList;
import java.util.Collections;

public class MainDriver 
{
	//Sort two employees based on their name, department, and age using the 
	//Comparator interface.
	
	public static void main(String[] args)  //main method, start of code execution
	{
		ArrayList<Employee> list = new ArrayList<>(); //ArrayList instance creation, that takes in Employee objects, ArrayList name is "list" 
		list.add(new Employee(33, "Damian", "Marketing")); //Employee instance creation, and adds Employee object to ArrayList "list", with values passed into the Employee object
		list.add(new Employee(22, "Ashley", "Finance")); //Employee instance creation, and adds Employee object to ArrayList "list", with values passed into the Employee object
		
		System.out.println("Unsorted"); //prints "Unsorted"
		System.out.println(list.get(0)); //prints the object's toString in index 0
		System.out.println(list.get(1)); //prints the object's toString in index 1
		
		System.out.println(); //creates empty line in console
		
		Collections.sort(list, new SortByAge()); //sorts the ArrayList "list" using the Comparator in the new instance of SortByAge
		System.out.println("Sorted by age"); //prints out statement "Sorted by age"
		System.out.println(list.get(0)); //prints the object's toString in index 0
		System.out.println(list.get(1)); //prints the object's toString in index 1
		
		System.out.println(); //creates empty line in console
		
		Collections.sort(list, new SortByName()); //sorts the ArrayList "list" using the Comparator in the new instance of SortByName
		System.out.println("Sorted by name"); //prints out statement "Sorted by name"
		System.out.println(list.get(0)); //prints the object's toString in index 0
		System.out.println(list.get(1)); //prints the object's toString in index 1
		
		System.out.println(); //creates empty line in console
		
		Collections.sort(list, new SortByDepartment()); //sorts the ArrayList "list" using the Comparator in the new instance of SortByDepartment
		System.out.println("Sorted by department"); //prints out statement "Sorted by department"
		System.out.println(list.get(0)); //prints the object's toString in index 0
		System.out.println(list.get(1)); //prints the object's toString in index 1
	}
}
