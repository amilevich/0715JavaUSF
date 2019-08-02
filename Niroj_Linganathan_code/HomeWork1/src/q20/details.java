package q20;
import java.io.Serializable;
public class details implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1847857974629662532L;

	private String FirstName;
	private String LastName;
	private String state;
	private int age;
	
	public details() {
		
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public details(String firstName, String lastName, String state, int age) {
		super();
		FirstName = firstName;
		LastName = lastName;
		this.state = state;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Name : " + FirstName +" "+ LastName + ",\n" + "state : " + state + ",\n"+ "age : " + age;
	}
	
	
}
