package com.project1.DAO;

import java.util.List;

import com.project1.model.Users;

public interface UsersDAO {
	
	
			//CREATE
			public int insertUsers(Users u);
		    
		    //READ
		    public Users selectUsersByUsersID(int UsersID);
		    public List<Users> selectAllUsers();
		    
		    //UPDATE
		    public int updateUsers(Users u);
		    
		    //DELETE    
		    public int deleteUsers(Users u);

			public Users selectUsersByUsername(String username);

			public Users selectUsersByPassword(String password);

			Users confirmLogin(String username1, String password1);


}
