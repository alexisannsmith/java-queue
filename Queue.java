/**************************************************************
 * 
 * 
 *      Queue.java
 *      Class creates a queue and defines
 *      the functions associated with sorting the queue
 * 
 *      quickSort, partition, and medianOfThree functions
 *      are used to implement the Quick Sort algorithm
 * 
 * 
 *************************************************************/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Queue {
    static ArrayList<Person> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void add(Person newPerson) {
        queue.add(newPerson);
    }

    /* Sorting method which implements Quick Sort
    Sorts by age from youngest to oldest */
    public static void quickSort(ArrayList<Person> queue, int first, int last, String whichSort) {
        if(first >= last) {
            return;
        }

        /* Find the pivot index for the age value
        Creates the partition: Smaller | Pivot | Larger */
        int pivotIndex = medianOfThree(first, last, whichSort);
        int p = partition(queue, first, last, pivotIndex, whichSort); // "p" represents partition value

        /* Sort the subarrays */
        quickSort(queue, first, p - 1, whichSort); // Sort the Smaller subarray
        quickSort(queue, p + 1, last, whichSort); // Sort the Larger subarray
    }

    /* Returns the index of the pivot for the age value
    Partitions an array as part of the Quick Sort algorithm into two subarrays: Smaller and Larger
    Entries in the Smaller subarray are <= the pivotValue
    Entries in the Larger subarray are >= the pivotValue */
    public static int partition(ArrayList<Person> queue, int first, int last, int pivotIndex,String whichSort) {
        int indexFromLeft, indexFromRight;

        /* Partition function for sorting by age */
        if(whichSort.equals("a") || whichSort.equals("A")) {
            int pivotValue = queue.get(pivotIndex).getAge();

            indexFromLeft = first + 1;
            indexFromRight = last - 1;

            boolean done = false;

            while(!done) {
                while(queue.get(indexFromLeft).getAge() < pivotValue) {
                indexFromLeft++;
            }

                while(queue.get(indexFromRight).getAge() > pivotValue) {
                    indexFromRight--;
                }

                if(indexFromLeft < indexFromRight) {
                    Collections.swap(queue, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } 
                else {
                    done = true;
                }
            }
            Collections.swap(queue, pivotIndex, indexFromLeft);
            return indexFromLeft;
        }

        /* Partition function for sorting by last name */
        else {
            String pivotValue = queue.get(pivotIndex).getLastName();

            indexFromLeft = first + 1;
            indexFromRight = last - 1;

            boolean done = false;

            while(!done) {
                while(queue.get(indexFromLeft).getLastName().compareTo(pivotValue) < 0) {
                indexFromLeft++;
            }

                while(queue.get(indexFromRight).getLastName().compareTo(pivotValue) > 0) {
                    indexFromRight--;
                }

                if(indexFromLeft < indexFromRight) {
                    Collections.swap(queue, indexFromLeft, indexFromRight);
                    indexFromLeft++;
                    indexFromRight--;
                } 
                else {
                    done = true;
                }
            }
            Collections.swap(queue, pivotIndex, indexFromLeft);
            return indexFromLeft;
        }
    }

    /* Finds the pivot index by using the median of three method */
    public static int medianOfThree(int first, int last, String whichSort) {
        int mid = (first + last) / 2;

        if(whichSort.equals("a") || whichSort.equals("A")) {
            /* Create a temporary array which holds the ages at the
            first, middle, and last indexes.
            The array is sorted and the middle index is compared to the values of
            first middle and last to find the median index */
            int[] tempArray = new int[3];
            int firstAge, midAge, lastAge, medianValue, pivot;
        
            firstAge = queue.get(first).getAge();
            midAge = queue.get(mid).getAge();
            lastAge = queue.get(last).getAge();

            tempArray[0] = firstAge;
            tempArray[1] = midAge;
            tempArray[2] = lastAge;

            Arrays.sort(tempArray);

            medianValue = tempArray[1];

            if(medianValue == firstAge) {
                pivot = first;
            }
            else if(medianValue == midAge) {
                pivot = mid;
            }   
            else {
                pivot = last;
            }

            Collections.swap(queue, mid, pivot);    // Swap the pivot index with the middle index
            Collections.swap(queue, mid, last - 1); // Swap the middle index with the second-to-last index
            pivot = last - 1; // Set the pivot to the second-to-last index

            if(queue.get(first).getAge() > queue.get(last).getAge()) { // Sort the first and last indexes
                Collections.swap(queue, first, last);
            }

            /* The first and last indexes should be sorted
            The middle index is the pivot which is now at last - 1 */

            return pivot;
        }
        else {  // Same process as above except comparing last name
            String tempArray[] = new String[3];
            String firstName, midName, lastName, medianValue;
            int pivot;
            
            firstName = queue.get(first).getLastName();
            midName = queue.get(mid).getLastName();
            lastName = queue.get(last).getLastName();

            tempArray[0] = firstName;
            tempArray[1] = midName;
            tempArray[2] = lastName;

            Arrays.sort(tempArray);

            medianValue = tempArray[1];

            if(medianValue.equals(firstName)) {
                pivot = first;
            }
            else if(medianValue.equals(midName)) {
                pivot = mid;
            }   
            else {
                pivot = last;
            }

            Collections.swap(queue, mid, pivot);    // Swap the pivot index with the middle index
            Collections.swap(queue, mid, last - 1); // Swap the middle index with the second-to-last index
            pivot = last - 1; // Set the pivot to the second-to-last index

            if(queue.get(first).getLastName().compareTo(queue.get(last).getLastName()) > 0) { // Sort the first and last indexes
                Collections.swap(queue, first, last);
            }

            /* The first and last indexes should be sorted
            The middle index is the pivot which is now at last - 1 */

            return pivot;
        }
    }

        
}
