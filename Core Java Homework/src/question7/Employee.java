package question7;
// name, department, age
class Employee 
{        
	   String name;
	   String department;
	  int age;    
	  Employee(String name, String department, int age)
	  {       
	    this.name=name;   
	    this.department=department; 
	    this.age=age;    
	    }
	  // getters and setters for name
	    public String getName() 
	    {  
	        return name;  
	    }  
	  
	    public void setName(String name) 
	    {  
	        this.name = name;  
	    }  
	 // getters and setters for department
	    public String getDep() 
	    {  
	        return department;  
	    }  
	  
	    public void setDep(String department) 
	    {  
	        this.department = department;  
	    }
	 // getters and setters for age
	    public int getAge() {  
	        return age;  
	    }  
	  
	    public void setAge(int age) {  
	        this.age = age;  
	    }  
	  
	    }