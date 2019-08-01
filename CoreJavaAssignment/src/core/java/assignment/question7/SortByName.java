package core.java.assignment.question7;

import java.util.Comparator;

public class SortByName implements Comparator<Employee>
{

    // Sorts two employees based on their name using the comparator interface.
    @Override
    public int compare(Employee o1, Employee o2)
    {
        return o1.getName().compareTo(o2.getName());
    }
}
