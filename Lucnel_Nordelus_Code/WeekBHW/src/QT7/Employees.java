package QT7;

public class Employees  {
	public String name;
	public String dept;
	public int age;
	
	//constructor
	public Employees(String name, String dept, int age) {
		this.name = name;
		this.dept = dept;
		this.age = age;
		
	}
// getters and settters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	//print all data as Strings
	@Override
    public String toString() {
        return "\nEmployee [Name = " + name + ", age = " + age + ", Department = " + dept + "]";
	
	}

}
