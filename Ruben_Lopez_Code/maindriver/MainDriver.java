package com.revature.maindriver;

import java.io.IOException;
import java.io.StringWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ErsReimbursementDaoImpls;
import com.revature.dao.ErsUsersDaoImpls;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;



public class MainDriver {
	
	final static Logger loggy = Logger.getLogger(MainDriver.class);
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		loggy.info("Hello");
		
		//method 1
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        
        System.out.println(timestamp);

        //method 2 - via Date
        Date date = new Date();
        System.out.println(new Timestamp(date.getTime()));

        //return number of milliseconds since January 1, 1970, 00:00:00 GMT
        System.out.println(timestamp.getTime());

        //format timestamp
        System.out.println(sdf.format(timestamp));
		System.out.println("Helloworld");
		
		
		ErsReimbursementDaoImpls ersreimbursementdaoimpls = new ErsReimbursementDaoImpls();
		
		List<ErsReimbursement> alist = ErsReimbursementDaoImpls.selectByUserID(9);
		
		for (int i = 0 ; i< alist.size(); i++) {
			System.out.println(alist.get(i).getReimbAmount());
		}
		
		
		
		//ErsReimbursement temp = ersreimbursementdaoimpls.selectErsReimbursementbyId(8);
		
		
		
		//temp.setReimbAmount(40);
		//ersreimbursementdaoimpls.updateReimbursement( temp);
		
		//System.out.println(temp.getReimbAmount());
		
		ErsUsersDaoImpls ersuserdaoimpls = new ErsUsersDaoImpls();
		
		ErsUsers tempusers = ersuserdaoimpls.selectErsUserbyUsername("Samout013");
		
		
		//String newstring = ErsReimbursementDaoImpls.selectAllReimbursement();		
		//System.out.println("the string is" + newstring);
		
		
		//tempusers.setErsUserName("LopezR014");
		System.out.println(tempusers.getErsUserName() + " " + tempusers.getErsUserId());
		
		//ErsReimbursement newtemp = new ErsReimbursement( 0, 20 , timestamp ,null ,null , null, 8 , 10, 1, 3);
		//ersreimbursementdaoimpls.insertErsReimbursement(newtemp);
		
		//ErsUsers tempuser1 = new ErsUsers(0,"Cat123","123","Giovanni", "Maldonado", "Gio@hotmail.com", 1 );
		//ersuserdaoimpls.insertErsUser(tempuser1);
		
		//ersuserdaoimpls.deleteErsUsersById(29);
		
		//ersreimbursementdaoimpls.deleteById(28);
		
		//System.out.println("success");
		
		
		//ersuserdaoimpls.updateUsers(tempusers);
		
		//your list
	    //final List<ErsReimbursement> list = new ArrayList<ErsReimbursement>();
	    


	   
		
		System.out.println("success");
		
	}
}
