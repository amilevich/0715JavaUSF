package dao.models;

public interface UsernameDAO {

	boolean createUAcct(Username account);

	Customer findAcctNum(String firstName, String lastName);

	boolean createUAJunc(String userName, int accountID);

}
