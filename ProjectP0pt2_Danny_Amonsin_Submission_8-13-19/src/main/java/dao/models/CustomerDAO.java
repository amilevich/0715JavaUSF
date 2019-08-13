package dao.models;

public interface CustomerDAO {

	boolean createCAcct(Customer account);

	JunctionInfo findPersRelAcct(String userName);

	void updateCustDB(int accountID, String verdict);

	void updateCustDBbalance(int accountID, double amount);

	Customer findAcctById(int accountid);

}
