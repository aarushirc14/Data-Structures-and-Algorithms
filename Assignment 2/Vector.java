/**
 * Author: Aarushi Roy Choudhury
 * Student ID: 30113987
 * Course: CPSC 319
 * Tutorial: T06
 * Assignment 2
 * Filename: Vector.java
 * Latest Version number: 5.7
 */
public class Vector {

    // Size of the Vector

    private int sizeM;

    // Max capacity of the current Vector

    private int capM;

    // Data structure to hold the refereces of linked lists

    public LinkedList[] storageM;

    // Create empty vector for cap=1

    public Vector() {
        this.sizeM = 0;
        this.capM = 1;
        storageM = new LinkedList[capM];

    }

    // Adds a new Linked List reference to the end of the vector, expands vector if
    // there is no space

    public void add(LinkedList newList) {
        if (sizeM + 1 > capM) {
            capM *= 2;
            LinkedList[] temp = new LinkedList[capM];
            for (int i = 0; i < sizeM; i++) {
                temp[i] = storageM[i];
            }
            temp[sizeM] = newList;
            storageM = temp;
            sizeM++;

        } else {
            storageM[sizeM] = newList;
            sizeM++;
        }
    }

    // getter
    public int getSize() {
        return sizeM;
    }

    // setter
    public void setIndex(LinkedList x, int i) {
        storageM[i] = x;
    }
}