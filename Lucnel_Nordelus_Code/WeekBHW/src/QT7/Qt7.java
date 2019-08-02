package QT7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Sort two employees based on their name, 
 * department, and age using the Comparator interface.
 */


public class Qt7 {
	
	public static void main(String[] args) {
		// created an ArrayList
		List<Employees>Employees = new ArrayList<Employees>();
		Employees.add(new Employees("Luke","IT",25)); //created and added to the Araylist
		Employees.add(new Employees("Lisa","Psy",30));//created and added to the Araylist
		
		//implemented the NameSorter, DeptNameSorter, AgeSorter on the Arraylist
		Collections.sort(Employees, new NameSorter()
                .thenComparing(new DeptNameSorter())
                .thenComparing(new AgeSorter()));
		
		System.out.println(Employees);
	}	
}




	
