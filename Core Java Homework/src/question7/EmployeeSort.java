package question7;
import java.util.*;    
 public class EmployeeSort
 {    
	 public static void main(String args[])
	 {    
	 //two employees
	 ArrayList<Employee> al=new ArrayList<Employee>();    
	 al.add(new Employee("Adam", "Sales", 23));    
	 al.add(new Employee("Ben", "HR", 26));    
	 al.add(new Employee("Charlie", "PR", 40));   
//Name  
	 Comparator<Employee> cm1=Comparator.comparing(Employee::getName);  
	 Collections.sort(al,cm1);  
	 System.out.println("Sorting by name");  
	 for(Employee emp: al)
	 {  
		 System.out.println(emp.name+" "+ emp.department + " " + emp.age);  
	 }  
//Department
	 Comparator<Employee> cm2=Comparator.comparing(Employee::getDep);  
	 Collections.sort(al,cm2);  
	 System.out.println("Sorting by department");  
	 for(Employee emp: al)
	 {  
		 System.out.println(emp.name+" "+ emp.department + " " + emp.age);  
	 }  
// Age  
	 Comparator<Employee> cm3=Comparator.comparing(Employee::getAge);  
	 Collections.sort(al,cm3);  
	 System.out.println("Sorting by age");  
	 for(Employee emp: al)
	 {  
		 System.out.println(emp.name+" "+ emp.department + " " + emp.age);  
	 }    
 }    
 }    


