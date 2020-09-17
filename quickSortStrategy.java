/**
 * Merge Sort Algorithm based on:
 * Lars Vogel
 * 2009
 * Quick Sort in Java - Tutorial
 * Version 0.7, 04.10.2016
 * Source Code
 * https://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
 */
package HW3;

import java.util.Arrays;

public class quickSortStrategy implements SortStrategy {
    private int[] numbers;

    @Override
    public void sort(int[] values) {
        System.out.println("Array before sorting:" + Arrays.toString(values));
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        int number = values.length;
        quicksort(0, number - 1);
        System.out.println("Array after " + getName() +"ing: " + Arrays.toString(values));
    }
    private void quicksort(int low, int high) {
        int i = low, j = high;
        int pivot = numbers[low + (high-low)/2];
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public String getName() {
        return "Quick Sort";
    }
}
