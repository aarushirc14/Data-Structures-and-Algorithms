/**
 * Author: Aarushi Roy Choudhury
 * Course: CPSC 319
 * Tutorial: T06
 * Assignment 2
 * Filename: QuickSort.java
 * Latest Version number: 5.7
 * Algorithms adapted from: https://www.geeksforgeeks.org/
 * (formal citation provided in report)
 */

// Modified quicksort to work with Vector containing linked lists

public class QuickSort {

    // Sort array into ascending order

    public void quickSort(Vector arr, int first, int last) {
        int lower = first + 1, upper = last;
        swap(arr, first, (first + last) / 2);

        // Choose the pivot
        String pivot = arr.storageM[first].head.data;

        while (lower <= upper) {
            while (arr.storageM[lower].head.data.compareTo(pivot) <= 0)
                lower++;
            while (arr.storageM[upper].head.data.compareTo(pivot) > 0)
                upper--;
            if (lower < upper)
                swap(arr, lower++, upper--);
            else
                lower++;
        }
        swap(arr, upper, first);
        if (first < upper - 1)
            quickSort(arr, first, upper - 1);
        if (upper + 1 < last)
            quickSort(arr, upper + 1, last);

    }

    public void quickSort(Vector arr) {
        if (arr.getSize() < 2)
            return;
        int max = 0;
        for (int i = 1; i < arr.getSize(); i++)
            if (arr.storageM[i].head.data.compareTo(arr.storageM[max].head.data) > 0)
                max = i;
        swap(arr, arr.getSize() - 1, max);
        quickSort(arr, 0, arr.getSize() - 2);

    }

    private void swap(Vector arr, int x, int y) {
        LinkedList temp = arr.storageM[x];
        arr.storageM[x] = arr.storageM[y];
        arr.storageM[y] = temp;
    }
}
