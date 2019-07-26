package core.java.assignment.question1;

public class BubbleSort
{
    public static void bubbleSort(int array[], int n)
    {
        for (int i=0; i<n-1; i++) {
            if (array[i] > array[i + 1]) {
                int temp = array[i];
                array[i] = array[i + 1];
                array[i + 1] = temp;
            }
        }
        if (n > 1)
        {
            bubbleSort(array, n - 1);
        }
    }
}
