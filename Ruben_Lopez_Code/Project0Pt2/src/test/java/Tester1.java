import static org.junit.Assert.*;

import org.junit.Test;

import com.revature.dao.AccountDaoImpls;
import com.revature.dao.UserbankDaoImpls;

public class Tester1 {

	@Test
	public void test() {
		AccountDaoImpls accountdaoimpls = new AccountDaoImpls();
		UserbankDaoImpls userbankdaoimpls = new UserbankDaoImpls();
		
		
		boolean hi = userbankdaoimpls.checkForUserAndPassword( "LopezR013" , "12345");
		assertEquals( true , hi);
	}

}
