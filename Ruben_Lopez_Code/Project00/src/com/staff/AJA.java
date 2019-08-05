package com.staff;

import java.util.Map.Entry;

import com.lopez.drive1.Customer;
import com.lopez.drive1.FileIn;

public class AJA {

	public static void approve() {
		// TODO Auto-generated method stub
		
		
		for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
  			
			int cup1 = ((Customer)FileIn.getLmao().get(entry.getKey())).getPendingJointNumber();
			int cup2 = ((Customer)FileIn.getLmao().get(cup1)).getPendingJointNumber();
			
  			if (cup2 == entry.getKey()) {
  				System.out.println("Cool");
  				
  				//pushing the values to be permanent
  				((Customer)FileIn.getLmao().get(entry.getKey())).setJointNumber(cup1);
  				((Customer)FileIn.getLmao().get(cup1)).setJointNumber(cup2);
  				
  				//resetting the pending joint accounts
  				((Customer)FileIn.getLmao().get(entry.getKey())).setPendingJointNumber(0);
  				((Customer)FileIn.getLmao().get(cup1)).setPendingJointNumber(0);
  				break;
  			}
			
			
		}
		
		System.out.println("Out of loop");
		
		
		
		
	}
	
	

}
