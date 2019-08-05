package com.lopez.drive1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Stack;

public class FileIn {
		
	
	//File in object declaration
	protected static LinkedHashMap< Integer, Object > lmao = new  LinkedHashMap<Integer, Object>();
		
		
		//Get Lmao
		public static LinkedHashMap<Integer, Object> getLmao() {
			return lmao;
		}


		// set lmao
		public static void setLmao(LinkedHashMap<Integer, Object> lmao) {
			FileIn.lmao = lmao;
		}



		@SuppressWarnings("unchecked")
		public static void mainFileIn() throws IOException {
			
			
			//Finds the path of the file 
		  	File filename = new File("D:\\spring workspace\\ProjectX\\src\\com\\lopez\\drive1\\hashmap.ser"); 
		   
		  
		 
		  	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
		  		
		  		
		  		 lmao = (LinkedHashMap<Integer, Object>) ois.readObject();
				//System.out.println(obj);
			} catch(IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		  	
		  	
			
			
			//System.out.println(lmao.keySet());
			//Customer getC1 = (Customer)lmao.get(1);
			//System.out.println(getC1.getCity());
	}
}
