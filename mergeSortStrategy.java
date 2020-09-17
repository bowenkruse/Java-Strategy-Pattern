/**
 * Merge Sort Algorithm based on:
 * Lars Vogel
 * 2009
 * Merge Sort in Java - Tutorial
 * Version 2.2, 29.09.2016
 * Source Code
 * https://www.vogella.com/tutorials/JavaAlgorithmsMergesort/article.html
 */
package HW3;
import java.util.Arrays;

public class mergeSortStrategy implements SortStrategy {
    private int[] numbers;
    private int[] helper;

    @Override
    public void sort(int[] toBeSorted) {
        this.numbers = toBeSorted;
        int number = toBeSorted.length;
        this.helper = new int[number];
        System.out.println("Array before sorting:" + Arrays.toString(toBeSorted));
        mergesort(0, number -1);
        System.out.println("Array after " + getName() + "ing: " + Arrays.toString(toBeSorted));
    }

    private void mergesort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergesort(low, middle);
            mergesort(middle + 1, high);
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        if (high + 1 - low >= 0) System.arraycopy(numbers, low, helper, low, high + 1 - low);
        int i = low;
        int j = middle + 1;
        int k = low;
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
    }

    public String getName() {
        return "Merge Sort";
    }
}
