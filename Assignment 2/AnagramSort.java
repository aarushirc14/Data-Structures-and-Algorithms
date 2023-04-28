
/** 
 * Author: Aarushi Roy Choudhury
 * Course: CPSC 319
 * Tutorial: T06
 * Assignment 2
 * Filename: AnagramSort.java
 * Latest Version number: 5.7
 * Algorithms adapted from: https://www.geeksforgeeks.org/ 
    (formal citation provided in report)
*/

import java.io.*;

public class AnagramSort {

    public static String sortString(String s) { // check if string is 1, return a single string
        if (s.length() == 1) {
            return s;
        } // 2 op

        // convert string to array and store
        char storage[]; // 1 op
        InsertionSort sortChars = new InsertionSort(); // 1 op
        storage = s.toCharArray(); // 3 op
        sortChars.sortChars(storage); // 3 op
        return new String(storage); // 3 op
    }

    public static void main(String[] args) {

        System.out.println("Sorting the " + args[0] + " file. Will put results in the " + args[1] + " file.");
        // Starting timer
        long start = System.nanoTime();

        Vector masterArray = new Vector();

        // Putting the words into an array
        // Error checking arguments with try and catch exception

        try {

            String word;
            String filePath = ("input/" + args[0]); // find file under "input" folder
            BufferedReader buffer = new BufferedReader(new FileReader(filePath));

            while ((word = buffer.readLine()) != null) {
                if (masterArray.getSize() == 0) {
                    Node tempNode = new Node(word, null);
                    LinkedList tempList = new LinkedList(tempNode);
                    masterArray.add(tempList);
                } else {
                    boolean cont = true;

                    for (int i = 0; cont && i < masterArray.getSize(); i++) { // 1 op to intitalize, 4ops each
                                                                              // iteration
                        String tempData = masterArray.storageM[i].head.data; // 5 ops
                        if (tempData.length() == word.length()) { // 5 ops
                            String temp1 = sortString(tempData); // 3 ops
                            String temp2 = sortString(word); // 3 ops
                            if (temp1.compareTo(temp2) == 0) {
                                masterArray.storageM[i].add(word);
                                cont = false;
                            }
                        }

                    }
                    if (cont == true) {
                        Node tempNode = new Node(word, null);
                        LinkedList tempList = new LinkedList(tempNode);
                        masterArray.add(tempList);
                    }
                }

            }
            buffer.close();

        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            System.exit(1);

        }

        // Sort the linked lists
        InsertionSort sortList = new InsertionSort();
        for (int i = 0; i < masterArray.getSize(); i++) {
            masterArray.setIndex(sortList.sortLinkedLists(masterArray.storageM[i]), i);
        }

        // Sort the Vector
        QuickSort sort = new QuickSort();
        sort.quickSort(masterArray);

        // Ending timer
        long end = System.nanoTime();
        long timeTaken = end - start;
        System.out.println("Time taken is: " + timeTaken * 1E-9 + " sec.");

        // Send output to file
        // Error checking with try and catch exception

        try {
            FileWriter writer = new FileWriter(args[1]);
            for (int i = 0; i < masterArray.getSize(); i++) {
                Node temp = masterArray.storageM[i].head;
                do {
                    writer.write(temp.data + " ");
                    temp = temp.next;

                } while (temp != null);
                writer.write("\r\n");

            }
            writer.close();

        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
        }
    }
}
