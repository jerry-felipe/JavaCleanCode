package algorithms;

import java.util.Scanner;

public class ArrayElement {

    public static int sum(int[] arrProduct) {
        int total = 0;
        for (int i = 0; i < arrProduct.length; i++) {
            total += arrProduct[i];
        }
        return total;
    }

    public static void mMethod() {
        int[] arr1 = new int[5];
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nFunction : Calculate the sum of the elements in an array :");
        System.out.println("--------------------------------------------------------------");

        System.out.println("Input 5 elements in the array :");
        for (int j = 0; j < 5; j++) {
            System.out.print("element - " + j + " : ");
            arr1[j] = scanner.nextInt();
        }
        System.out.println("The sum of the elements of the array is " + sum(arr1));
    }

    public static void main(String[] args) {
        mMethod();
    }
}
