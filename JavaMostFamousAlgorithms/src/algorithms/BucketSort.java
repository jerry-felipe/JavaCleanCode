package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {

    // Bucket sort breaks a list down into sub-lists, you can then use another algo to sort the sub-lists
    // Bucket sort isn't a good choice if you don't know the range or distribution of the data
    // Bucket Sort time complexity
    // Average case: O(n+k) - k being the number of buckets that were created
    // Worst case: O(N^2)

    // In this case, we will focus on building an algorithm that uses bucket sort to sort an array of integers between 1 and 99
    // we will also assume that the integers in the passed array are evenly distributed
    public static List<Integer> bucketSort(int... x) {
        List<Integer> result = new ArrayList<>();

        // Determine how many buckets you want to create, in this case, the 10 buckets will each contain a range of 10
        // 1-10, 11-20, 21-30, etc. since the passed array is between 1 and 99
        int numOfBuckets = 10;

        // Create buckets
        List<Integer>[] buckets = new List[numOfBuckets];
        for (int i = 0; i < numOfBuckets; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Iterate through the passed array and add each integer to the appropriate bucket
        for (int i = 0; i < x.length; i++) {
            int bucketChoice = (x[i] / numOfBuckets);
            buckets[bucketChoice].add(x[i]);
        }

        // Sort each bucket and add it to the result List
        // Each sublist is sorted using Bubble sort, but you could substitute any sorting algo you would like
        for (int i = 0; i < numOfBuckets; i++) {
            int[] temp = bubbleSortList(buckets[i]);
            for (int val : temp) {
                result.add(val);
            }
        }
        return result;
    }

    // Bubble sort with List input
    public static int[] bubbleSortList(List<Integer> input) {
        int[] array = input.stream().mapToInt(i -> i).toArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    // Call to test
    public static void main(String[] args) {
        int[] x = new int[]{99, 95, 90, 85, 80, 75, 70, 65, 60, 55, 50, 45, 40, 35, 30, 25, 20, 15, 10, 5, 1};
        List<Integer> sorted = bucketSort(x);
        for (int i : sorted) {
            System.out.println(i);
        }
    }
}
