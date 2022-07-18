/*************************************************************
 * 
 * 
 *            QueueTest.java
 *            Test class for Queue.java
 * 
 * 
 ***********************************************************/




import java.util.Scanner;

public class QueueTest extends Queue {
    static Scanner scnr = new Scanner(System.in);

    /* testSort function
    Asks user whether they want to sort by age or last name
    Calls quickSort function from Queue.java to sort the queue
    based on the user's choice
    Also tests the toString function from Person.java
    to print the sorted queue */
    public static void testSort() {
        String whichSort;

        System.out.println("If sorting by age ------- press a and hit enter..." +
        "\nIf sorting by last name ------- press n and hit enter...");

        whichSort = scnr.nextLine();
        scnr.close();

        quickSort(queue, 0, queue.size() - 1, whichSort);

        System.out.println("Sorted: " + queue.toString());
    }

    /* addPeople function
    Takes input from user for 5 people's names and ages and
    adds them to a queue */
    public static void addPeople() {
        Queue queue = new Queue();

        String firstName, lastName;
        int age;
    
        int count = 0;

        while(count < 5) {
            System.out.println("Enter first name: ");
            firstName = scnr.nextLine();

            System.out.println("Enter last name: ");
            lastName = scnr.nextLine();

            System.out.println("Enter age: ");
            age = scnr.nextInt();

            scnr.nextLine();

            Person person = new Person(firstName, lastName, age);

            queue.add(person);

            count++;
        }
    }

    public static void main(String[] args) {
        addPeople();
        testSort();
    }
}
