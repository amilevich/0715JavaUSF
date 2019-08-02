package QT7;

import java.util.Comparator;

public class MultipleFieldSorter {
	
}

	//created name sorter by implementing Comparator interface
class NameSorter implements Comparator<Employees>
	{
	    public int compare(Employees o1, Employees o2)
	    {
	        return o1.getName().compareTo(o2.getName());
	    }
	}
	// created age sorter by implementing Comparator interface
class AgeSorter implements Comparator<Employees>
	{
	    public int compare(Employees o1, Employees o2)
	    {
	        return o1.getAge() - o2.getAge();
	    }
	}
	
	
	// created dept sorter by implementing Comparator interface
class DeptNameSorter implements Comparator<Employees>
	{
	    public int compare(Employees o1, Employees o2)
	    {
	        return o1.getDept().compareTo(o2.getDept());
	    }
	}


