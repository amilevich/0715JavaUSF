package com.bank.app.mainInterface;

import java.util.List;

import com.AccountStuff.Accountinfo;
import com.AccountStuff.Accounts;

public interface AccountInfoDAO {
	
	//CREATE
    public int insert(Accounts accountinfo);
    
    //READ
    public Accountinfo selectAccountinfoByAccount_number(String account_number);
    public List<Accountinfo> selectAllAccountinfo();
    
    //UPDATE
    public int updateAccountinfo(Accounts accoutinfo);
    
    //DELETE    
    public int deleteAccountinfo(Accounts accountinfo);


}
