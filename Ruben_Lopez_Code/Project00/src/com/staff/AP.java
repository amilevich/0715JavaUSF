package com.staff;

import com.lopez.drive1.FileIn;

import java.util.LinkedHashMap;

import com.lopez.drive1.Customer;

import com.userinterface.UserInterface;

public class AP {

	public static void addApplication() {
		
		//using the get methods to push through their value to a  constructor of customer. 
		Customer tempCustomer = new Customer(	500.00,
												UserInterface.getTempAccount().getTempFirstName(),
												UserInterface.getTempAccount().getTempLastName(),
												UserInterface.getTempAccount().getTempAddress(),
												UserInterface.getTempAccount().getTempCity(),
												UserInterface.getTempAccount().getTempUser(),
												UserInterface.getTempAccount().getTempPassword());
		
		
		//Account Number Generator
		boolean flag = true; 
		
		
		//checking for empty memory location
		for ( int i = 1 ; i < FileIn.getLmao().size() +1 ; i++) {
			
			//if empty memory location is found
			if ((FileIn.getLmao().containsKey(i) == false) ){
				
				//Generating a dummy hash map 
				LinkedHashMap<Integer,Object> temphash = FileIn.getLmao();
				
				//Putting in new Customer object into new memory location
				temphash.put( i , tempCustomer);
				FileIn.setLmao(temphash);
				flag = false;
			}
		}
		
		//Only activates if no memory location is found
		if (flag == true) {
			
			
			//Generating a dummy hash map 
			LinkedHashMap<Integer,Object> temphash = FileIn.getLmao();
			
			//Putting in new Customer object into new memory location
			temphash.put( FileIn.getLmao().size() + 1  , tempCustomer);
			FileIn.setLmao(temphash);
			flag = false;
		}
		for (int i = 1; i < FileIn.getLmao().size() + 1; i++) {          
      	//creating a temporary object from the HashMap for terminal view
			Customer getC1 = (Customer)FileIn.getLmao().get(i);
          System.out.println(i + ":" + getC1.balance + ":" + getC1.fName + ":" + getC1.lName + ":" + getC1.address + ":" + getC1.city + ":" + getC1.userName + ":" + getC1.passWord);
      }
		
	}
}
