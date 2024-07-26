import java.util.*;

public class GenericQueue {

    public static void main(String[] args) {
        Queue<String> numbers = new LinkedList<>();
        numbers.add("one");
        numbers.add("two");
        numbers.add("three");
        numbers.add("four");
        numbers.add("five");

        // A queue can be enumerated without disturbing its contents.
        for (String number : numbers) {
            System.out.println(number);
        }

        System.out.println("\nDequeuing '" + numbers.poll() + "'");
        System.out.println("Peek at next item to dequeue: " + numbers.peek());
        System.out.println("Dequeuing '" + numbers.poll() + "'");

        // Create a copy of the queue, using the constructor that accepts a Collection.
        Queue<String> queueCopy = new LinkedList<>(numbers);

        System.out.println("\nContents of the first copy:");
        for (String number : queueCopy) {
            System.out.println(number);
        }

        // Create an array twice the size of the queue and copy the elements of the queue.
        String[] array2 = new String[numbers.size() * 2];
        numbers.toArray(array2);

        // Create a second queue, using the constructor that accepts a Collection.
        Queue<String> queueCopy2 = new LinkedList<>(Arrays.asList(array2));

        System.out.println("\nContents of the second copy, with duplicates and nulls:");
        for (String number : queueCopy2) {
            System.out.println(number);
        }

        System.out.println("\nqueueCopy.contains(\"four\") = " + queueCopy.contains("four"));

        System.out.println("\nqueueCopy.clear()");
        queueCopy.clear();
        System.out.println("\nqueueCopy.size() = " + queueCopy.size());
    }
}
