package musicinventorysystem;

import java.util.LinkedList;
import java.lang.reflect.Array;

/**
 *
 * @author Matt Gulbronson
 */
public class InventorySystem {

    LinkedList<User> users = new LinkedList();
    LinkedList<Instruments> instruments = new LinkedList();

    void addUser(User u) {
        users.add(u);
    }

    void removeUser(User u) {

    }

    
    /**
     * Sorts an unsorted array of objects which implement the comparable
     * interface using the bubble-sort algorithm
     *
     * @param unsorted the array of comparable objects to be sorted
     */
    public void bubbleSort(Comparable[]<User> unsorted) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < unsorted.length - 1; i++) {
                if (unsorted[i].compareTo(unsorted[i + 1].lName) > 0) {
                    unsorted = (Comparable[]) swap(i, i + 1, unsorted);
                    swapped = true;
                }
            }
        } while (swapped);
    }
    /**
     * Swaps two objects in an array
     *
     * @param m
     * @param n
     * @param array the array of object
     * @return the array with the objects at indices m & n switched
     */
    public Object[] swap(int m, int n, Object[] array) {
        Object temp = array[m];
        Array.set(array, m, array[n]);
        Array.set(array, n, temp);
        return array;
    }
    
}
