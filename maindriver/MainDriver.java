package com.project1.maindriver;

import java.util.List;

import com.project1.DAO.ReimbursementDAOImpl;
import com.project1.DAO.UsersDAOImpl;
import com.project1.model.Reimbursement;
import com.project1.model.Users;

public class MainDriver {
	
public static void main(String[] args) {
		
		//Users user1 = new Users(1, "billy", "clinclin" ,"Bill", "Clinton","billclinton@whitehouse.com",1);
		
		UsersDAOImpl usersDAOImpl = new UsersDAOImpl();
		ReimbursementDAOImpl reimbursementDAOImpl = new ReimbursementDAOImpl();
		
		 Users help =usersDAOImpl.selectUsersByUsername("gaelgino");
		 
		 System.out.println(help.getUsersID());
		//System.out.println(usersDAOImpl.insertUsers(user1));
		
		//usersDAOImpl.confirmLogin("gaelgino", "lalala");
		
		
		//System.out.println(usersDAOImpl.confirmLogin("gaelgino", "lalala"));
		//System.out.println(reimbursementDAOImpl.selectByUsersID(12));
		
		
		
		ReimbursementDAOImpl reimbursementDAOImpl1 = new ReimbursementDAOImpl();
		
List<Reimbursement> alist = reimbursementDAOImpl1.selectByUsersID(12);
        
        for (int i = 0 ; i< alist.size(); i++) {
            System.out.println(alist.get(i).getReimb_ID());
        }
		
	}

}
