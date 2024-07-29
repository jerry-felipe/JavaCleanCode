package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> qt = new LinkedList<>();
        qt.add(1);
        qt.add(2);
        qt.add(3);

        for (Integer obj : qt) {
            System.out.println(obj);
        }

        System.out.println();
        System.out.println();
        System.out.println("The number of elements in the Queue: " + qt.size());
        System.out.println("Does the Queue contain 3? " + qt.contains(3));
    }
}
