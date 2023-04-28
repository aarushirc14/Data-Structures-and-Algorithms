/**
 * Author: Aarushi Roy Choudhury
 * Course: CPSC 319
 * Tutorial: T06
 * Assignment 2
 * Filename: InsertionSort.java
 * Latest Version number: 5.7
 * Algorithms adapted from: https://www.geeksforgeeks.org/
 * (formal citation provided in report)
 */
public class InsertionSort {

    public LinkedList sortLinkedLists(LinkedList ll) {
        if (ll.head.next == null) {
            return ll;
        }

        LinkedList tempList = new LinkedList();
        tempList.head = new Node(ll.head.data, null);

        Node tempNode = ll.head.next;
        do {
            if ((tempNode.data).compareTo(tempList.head.data) <= 0) {
                tempList.add(tempNode.data);
            } else {
                Node temp = tempList.head;
                while (temp.next != null && (tempNode.data).compareTo(temp.next.data) > 0) {
                    temp = temp.next;
                }
                tempList.insertAfter(tempNode.data, temp);
            }

            tempNode = tempNode.next;
        } while (tempNode != null);

        return ll = tempList;
    }

    public void sortChars(char[] arr) {
        for (int i = 1, j; i < arr.length; i++) // 2 op intitally, k loops of 2 ops
        {
            char temp = arr[i]; // 2 ops
            for (j = i; j > 0 && temp < arr[j - 1]; j--) // 1 op, k loops of 4 ops
                arr[j] = arr[j - 1]; // 3 ops
            arr[j] = temp; // 3 ops
        }
    }
}
