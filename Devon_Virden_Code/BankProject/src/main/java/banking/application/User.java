package banking.application;

import java.io.Serializable;

import org.apache.log4j.Logger;

abstract class User implements Serializable {

	private static final long serialVersionUID = -2983128934742434458L;
	protected final static Logger ibis = Logger.getLogger(User.class);
	protected String name;
	String type;

	public User(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	void greeting() {
		System.out.println("Hello " + name + "!");
	}

	abstract void printUser();

	abstract void signIn(Menu menu);

	abstract protected void save();

	public abstract String toString();

	void signOut(Menu menu) {
		System.out.println("Goodbye");
		save();
		ibis.info(name + " signed out.");
		menu.mainMenu();
	}
}
