package Junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Model.Account;
import Model.BasicAccount;

public class AccountJUnitTest {
    
    private Account testAccount;   // Declare Testing Class Instance........
    
    public AccountJUnitTest() {
    }
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        System.out.println("Start Account Class Testing");
        char [] accolderName = {'A','l','i'} ; 
        double balance = 10000.0;
        char type = 'B';
        testAccount = new BasicAccount(accolderName,balance,type);        // Initialize Testing Class Instance......
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void withdrawTestCase() {

        testAccount.Withdraw(5000.0);
        double actualBalance = testAccount.getCurrentBalance();
        System.out.println("Remaining Balance: " + testAccount.getCurrentBalance());

        double expectedBal = 5000.0;
        assertEquals(expectedBal , actualBalance);
    }
	
    @Test
    public void depositeTestCase() {

            double prevBal = testAccount.getCurrentBalance();
            testAccount.Deposit();
            double totBal = testAccount.getCurrentBalance();
            System.out.println("Total Balance: " + testAccount.getCurrentBalance());

           boolean expected = totBal > prevBal;
            assertEquals(expected,true);
            //fail("Not yet implemented");
    }
}

