package com.lopez.drive1;
import com.lopez.drive1.FileIn;
import com.lopez.drive1.*;

import com.staff.*;
import com.staff.Employee;

import java.io.*;
import java.util.List;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOut {
	
 
  
    
    
    
    public FileOut() {
        
    }
    
    public static void main(String[] args) throws IOException {
		System.out.println("Lulz");
		
		
		
		writeList();
	}
    
    
    public static void writeObject(String filename, LinkedHashMap< Integer, Object > hashMap) {
    	
    	try
        {
               FileOutputStream fos = new FileOutputStream("D:\\spring workspace\\ProjectX\\src\\com\\lopez\\drive1\\hashmap.ser");
               ObjectOutputStream oos = new ObjectOutputStream(fos);
            	   
               oos.writeObject(hashMap);
               
              
               oos.close();
               fos.close();
               System.out.println("Serialized HashMap data is saved in hashmap.ser");
        }catch(IOException ioe)
         {
               ioe.printStackTrace();
         }
	}
    
    
    
    
    
	public static void  writeList() throws IOException {
    	
    	
    	FileIn.mainFileIn();
    	LinkedHashMap< Integer, Object > hashMap = FileIn.getLmao();
    	//hashMap.put(1, new Customer(250.75,"Ruben","Lopez","13765 Valera Way","Victorville","LopezR013", "12345"));
    	//hashMap.put(2, new Employee(5250.75,"Sam","Jones","1335 Win st","Radient Gardens","MyDude", "12345"));
    	//hashMap.put(3, new Customer(6540.78,"Guy","furri","1336 Gravy St","Flavor Town","MyDude2", "12345"));
    	//hashMap.put(4, new Admin(2540.78,"Dillion","Francis","1336 east Ln ","st Lolzers","Cat123", "12345"));
    	
    	
        
        
        String outFile1 = "D:\\spring workspace\\ProjectX\\src\\com\\lopez\\drive1\\OutFile.txt";
        
        writeObject(outFile1, hashMap);
    	
        //terminals
       for (int i = 1; i < FileIn.getLmao().size() + 1; i++) {
//            
//        	//creating a temporary object from the HashMap for terminal view
        	Customer getC1 = (Customer)FileIn.lmao.get(i);
        	
            System.out.println(i + ":" + getC1.balance + ":" + getC1.fName + ":" + getC1.lName + ":" + getC1.address + ":" + getC1.city + ":" + getC1.userName + ":" + getC1.passWord);
        }
       
       	for (Entry<Integer, Object> entry : FileIn.getLmao().entrySet()) {
  			
  			//Checks if input is equal to the user name inside an object, through a for each loop of entry key, inside a map 'LMAO', through File class
  		    if ("Cat123".equals((((Customer) FileIn.getLmao().get(entry.getKey())).getUserName() )) ) {
  				System.out.println((FileIn.getLmao().get(entry.getKey())) instanceof Admin);
  				
  		    }
		}
	
	
	}
	
}
