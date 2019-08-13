package banking.application;

import banking.DAO.AccountDAOImpl;
import banking.DAO.UserDAOImpl;

public class Storage<K, V> {

	UserDAOImpl udao = new UserDAOImpl();
	AccountDAOImpl adao = new AccountDAOImpl();
	int size = 0;

	public void setSize(int size) {
		this.size = size;
	}

	public void put(String key, User value) {
		if (!udao.findUser((String) key)) {
			udao.addUser((User) value);
		}
		size++;
	}

	public void put(Account value) {
		adao.addAccount((Account) value);
		size++;
	}

	public User get(String key) {
		return udao.getUser(key);
	}

	public Account get(int key) {
		return adao.getAccount(key);
	}

	public boolean containsKey(int key) {
		return adao.findAccount(key);
	}

	public boolean containsKey(String key) {
		return udao.findUser(key);
	}

	public int size() {
		return size;
	}
}
