import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.ErsReimbursementDaoImpls;
import com.revature.dao.ErsUsersDaoImpls;
import com.revature.model.ErsReimbursement;
import com.revature.model.ErsUsers;



public class Tester1 {

	@Test
	public void testUpdateAmount() {
		
		
		
		ErsReimbursementDaoImpls ersreimbursementdaoimpls = new ErsReimbursementDaoImpls();
		ErsReimbursement temp = ersreimbursementdaoimpls.selectErsReimbursementbyId(8);
		
		
		
		temp.setReimbAmount(40);
		ersreimbursementdaoimpls.updateReimbursement( temp);
		
		temp = ersreimbursementdaoimpls.selectErsReimbursementbyId(8);
				
		assertEquals( 40 , temp);
	}
	
	
	@Test
	public void UserAssert() {
		
		
		ErsUsersDaoImpls ersUserDaoImpls = new ErsUsersDaoImpls();
		
		ErsUsers tempusers = ersUserDaoImpls.selectErsUserbyUsername("Samout013");
		
		ErsUsers tempusers1 = ersUserDaoImpls.selectErsUserbyId(9);
		
		
		int lol = tempusers.getErsUserId();
		int lol2 = tempusers1.getErsUserId();
				
		assertEquals( lol , lol2);
	}
	

}
