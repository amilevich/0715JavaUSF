package com.homework.q7;

import java.util.ArrayList;
import java.util.Collections;



public class Employeet {

	public static void main(String[] args) {

			
			ArrayList<Employee> listOfServ = new ArrayList<>();
			
			//Employee John = new Employee("John",533, 34);
			//Employee Susan = new Employee("Susan", 276, 25);
//			Employee Sam = new Employee("Sam", 678, 33);
//			Employee Dylan = new Employee("Dylan", 563, 88);
			
			listOfServ.add(new Employee("John",533, 34));
			listOfServ.add(new Employee("Susan", 276, 25));
			listOfServ.add(new Employee("Sam", 678, 33));
			listOfServ.add(new Employee("Dylan", 563, 88));
			
			for(Employee serv : listOfServ) {
				System.out.println(serv);
			}
			System.out.println();
			
			Collections.sort(listOfServ, new SortName());
			for (int i = 0; i < listOfServ.size(); i++) {
				System.out.println(listOfServ.get(i));
			}
			System.out.println();
			
			Collections.sort(listOfServ, new SortDepartment());
			for (int i = 0; i < listOfServ.size(); i++) {
				System.out.println(listOfServ.get(i));
			}
			System.out.println();
			
			Collections.sort(listOfServ, new SortAge());
			for (int i = 0; i < listOfServ.size(); i++) {
				System.out.println(listOfServ.get(i));
			}
			System.out.println();
		}
	}

