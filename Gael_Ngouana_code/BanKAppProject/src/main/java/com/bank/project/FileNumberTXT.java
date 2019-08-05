package com.bank.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileNumberTXT {
	
			
		public boolean writerFile(String filename, long number) {
			File file = null;
			
			
			try {
				file = new File(filename);			
				if(!file.exists()) {
					file.createNewFile();				
				}											
				ObjectOutputStream obj = new ObjectOutputStream( new FileOutputStream(file));
				obj.writeObject(number);
				obj.close();
				return true;
				
			}catch(Exception fileExp) {
				fileExp.printStackTrace();
				return false;			
			}

		}
		
		
		
		public  long  readFile(String filename) {
			
			 	
			try {
				FileInputStream file = new FileInputStream(filename);
				ObjectInputStream obj = new ObjectInputStream(file);
				long t;
				
				 t =  (long) obj.readObject();
				
				return t;
							
			} catch (Exception e) {
				e.printStackTrace();
				return 0;
			}
			
			
		}
		
		


}
