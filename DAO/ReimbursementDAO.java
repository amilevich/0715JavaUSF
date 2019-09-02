package com.project1.DAO;

import java.util.List;

import com.project1.model.Reimbursement;

public interface ReimbursementDAO {
	
	//CREATE
	public int insertReimbursement(Reimbursement r);
    
    //READ
    public Reimbursement selectReimbursementByReimbID(int reimb_ID);
    public List<Reimbursement> selectReimbursementByStatus(String reimb_Status);
    public List<Reimbursement> selectAllReimbursements();
    public List<Reimbursement> selectByUsersID(int userid);
    
    //UPDATE
    public int updateReimbursement(Reimbursement r);
    
    //DELETE    
    public int deleteReimbursement(Reimbursement r);

	


}
