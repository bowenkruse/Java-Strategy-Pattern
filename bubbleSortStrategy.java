/**
 * Bubble Sort Algorithm from:
 * Rajat Mishra
 * 12-01-18
 * Java Program for Bubble Sort
 * Source Code
 * https://www.geeksforgeeks.org/java-program-for-bubble-sort/
 */
package HW3;
import java.util.Arrays;

public class bubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(int[] toBeSorted) {
        // array before sorting for comparison
        System.out.println("Array before sorting:" + Arrays.toString(toBeSorted));
        int n = toBeSorted.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (toBeSorted[j] > toBeSorted[j+1])
                {
                    // swap temp and arr[i]
                    int temp = toBeSorted[j];
                    toBeSorted[j] = toBeSorted[j+1];
                    toBeSorted[j+1] = temp;
                }
        System.out.println("Array after " + getName() +"ing:" + Arrays.toString(toBeSorted));
    }
    public String getName() {
        return "Bubble Sort";
    }
}
