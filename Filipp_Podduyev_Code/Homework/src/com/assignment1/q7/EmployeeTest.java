package com.assignment1.q7;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	  
	 
    @Test
    public void testEmployeeSorting(){
        Employee e1 = new Employee("John", "Sales", 26);
        Employee e2 = new Employee("Lilly", "Util", 22);
      
        List<Employee> listOfEmployees = new ArrayList<Employee>();
        listOfEmployees.add(e1);
        listOfEmployees.add(e2);

        System.out.println("Unsorted List : " + listOfEmployees);
      
        Collections.sort(listOfEmployees);
        assertEquals(e1, listOfEmployees.get(0));
        assertEquals(e2, listOfEmployees.get(1));
      
    }
}
