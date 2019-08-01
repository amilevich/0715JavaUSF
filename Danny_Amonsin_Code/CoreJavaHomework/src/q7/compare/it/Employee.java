package q7.compare.it;

public class Employee //Employee class for creating Employee objects
{
	int age; //declaring age variable as integer
	String name, department; //declaring name, department variable as a String
	
	public Employee(int age, String name, String department) //constructor for Employee class taking in integer age, String name and department
	{
		this.age = age; //connects argument passed in for age into the object created
		this.name = name; //connects argument passed for name into the object created
		this.department = department;	//connects argument passed for department into the object created		
	}
	
	public String toString() //toString override for when we print out this object
	{
		return this.name + " " + this.age + " " + this.department;
	}
}	
