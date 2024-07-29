package algorithms;

public class CodingAlgorithm {
    public static class RotateArrayRight {
        // Rotate array to the right of a given pivot
        public static int[] rotate(int[] x, int pivot) throws Exception {
            if (pivot < 0 || x == null) {
                throw new Exception("Invalid argument");
            }

            pivot = pivot % x.length;

            // Rotate first half
            x = rotateSub(x, 0, pivot - 1);

            // Rotate second half
            x = rotateSub(x, pivot, x.length - 1);

            // Rotate all
            x = rotateSub(x, 0, x.length - 1);

            return x;
        }

        private static int[] rotateSub(int[] x, int start, int end) {
            while (start < end) {
                int temp = x[start];
                x[start] = x[end];
                x[end] = temp;
                start++;
                end--;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        try {
            int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
            int pivot = 3;
            int[] rotatedArray = RotateArrayRight.rotate(array, pivot);
            for (int num : rotatedArray) {
                System.out.print(num + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
