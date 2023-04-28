
/** 
 * Author: Aarushi Roy Choudhury
 * Course: CPSC 319
 * Tutorial: T06
 *  Assignment 1
 * Filename: Assign1.java
 * Latest Version number: 5.7
 * Algorithms adapted from: https://www.geeksforgeeks.org/ 
    (formal citation provided in report)
    */

import java.util.Random;
import java.util.Arrays;
import java.io.PrintWriter;
import java.io.IOException;

public class Assign1 {

    public static void main(String[] args) throws IOException {

        String order = args[0]; // 1st arg order
        int n = Integer.parseInt(args[1]); // 2nd arg length of array -> need to convert str to int
        String algo = args[2]; // 3rd arg algo
        String outputFilename = args[3]; // 4th arg output file name

        errorChecking(order, n, algo);

        int[] generatedArray = { 0 }; // intializing the array

        // populating generatedArray based on user order choice
        if (order.equals("random")) {
            System.out.println("random");
            generatedArray = random(n);
        }

        else if (order.equals("ascending")) {
            System.out.println("ascending");
            generatedArray = ascending(n);
        }

        else if (order.equals("descending")) {
            System.out.println("descending");
            generatedArray = descending(n);
        }

        PrintWriter printOutput = new PrintWriter(outputFilename);

        // Calling method based on user algorithm choice.

        if (algo.equals("selection")) {
            System.out.println("selection");
            int[] sortedArray = selectionSort(n, generatedArray);
            for (int a : sortedArray)
                printOutput.println(a);
            printOutput.close();
        }

        else if (algo.equals("insertion")) {
            System.out.println("insertion");
            var sortedArray = insertionSort(n, generatedArray);
            for (int a : sortedArray)
                printOutput.println(a);
            printOutput.close();
        }

        else if (algo.equals("merge")) {
            System.out.println("merge");
            var sortedArray = mergeSort(generatedArray);
            for (int a : sortedArray)
                printOutput.println(a);
            printOutput.close();
        }

        else if (algo.equals("quick")) {
            System.out.println("quick");
            var sortedArray = quickSort(generatedArray, 0, generatedArray.length - 1);
            for (int a : sortedArray)
                printOutput.println(a);
            printOutput.close();
        }

    }

    // Error Checking
    public static void errorChecking(String order, int n, String algo) {
        if (Integer.signum(n) == -1 || Integer.signum(n) == 0) {
            System.out.println("Error: Please enter a positive number greater than 0.");
            System.out.println("Program Terminated.");
            System.exit(1);
        }

        if (!order.equals("random") && !order.equals("ascending") && !order.equals("descending")) {

            System.out.println(
                    "Please enter one of the following orders (case sensitive): random, ascending or descending. ");
            System.out.println("Program Terminated.");
            System.exit(1);
        }

        if (!algo.equals("selection") && !algo.equals("insertion") && !algo.equals("merge") && !algo.equals("quick")) {
            System.out.println(
                    "Please enter one of the following algorithms (case sensitive): selection, insertion, merge or quick. ");
            System.out.println("Program Terminated.");
            System.exit(1);
        }
    }

    // Implentation of random, ascending, descending ordered arrays.
    public static int[] random(int n) {
        Random rd = new Random(); // creating Random object
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rd.nextInt();
        }
        return arr;
    }

    public static int[] ascending(int n) {// consecutive numbers in ascending order eg. {1,2,3,4,5...}
        int[] arr = new int[n];
        for (int k = 0; k < arr.length; k++)
            arr[k] = k + 1;

        return arr;
    }

    public static int[] descending(int n) {// random numbers in descending order eg. {200,18,2,-1...}
        int[] arr = random(n);
        for (int k = 0; k < arr.length; k++) {
            for (int j = k; j < arr.length; j++) {
                if (arr[k] < arr[j]) {
                    int temp = arr[k];
                    arr[k] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    // Implentation of algorithms: selection, insertion, mereg and quick.

    public static int[] selectionSort(int n, int[] arr) {

        // Find the minimum element in unsorted array

        long startTime = System.nanoTime();
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx])
                    min_idx = j;

                // Swap the found minimum element with the first
                // element
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
            }

        }
        long endTime = System.nanoTime();
        System.out.println("Time in nanoseconds:" + (endTime - startTime));

        return arr;
    }

    public static int[] insertionSort(int n, int[] arr) {
        // int[] arr = random(n);
        long startTime = System.nanoTime();

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /*
             * Move elements of arr[0..i-1], that are
             * greater than key, to one position ahead
             * of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        long endTime = System.nanoTime();
        System.out.println("Time in nanoseconds:" + (endTime - startTime));
        return arr;
    }

    public static int[] mergeSort(int[] arr) {
        long startTime = System.nanoTime();

        if (arr.length > 1) {
            int mid = arr.length / 2;

            // Split left part
            int[] left = new int[mid];
            for (int i = 0; i < mid; i++) {
                left[i] = arr[i];
            }

            // Split right part
            int[] right = new int[arr.length - mid];
            for (int i = mid; i < arr.length; i++) {
                right[i - mid] = arr[i];
            }
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while (i < left.length) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < right.length) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Time in nanoseconds:" + (endTime - startTime)); // multiple times will be printed (because
                                                                            // this function is recursive)
                                                                            // only the last time printed (the longest
                                                                            // one) should be considere
        return arr;
    }

    public static int[] quickSort(int arr[], int begin, int end) {
        long startTime = System.nanoTime();
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
        long endTime = System.nanoTime();
        System.out.println("Time in nanoseconds:" + (endTime - startTime));// multiple times will be printed (because
                                                                           // this function is recursive) only the last
                                                                           // time printed (the longest one) should be
                                                                           // considered

        return arr;
    }

    private static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
