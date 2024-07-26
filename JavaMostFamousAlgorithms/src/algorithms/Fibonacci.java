import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        int prv = 0, pre = 1, trm, i, n;

        System.out.println("\nDisplay the first n terms of fibonacci series:");
        System.out.println("------------------------------------------------\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input number of terms to be displayed: ");
        n = scanner.nextInt();
        scanner.close();

        System.out.printf("Here is the fibonacci series up to %d terms:\n", n);
        System.out.printf("%d    %d", prv, pre);

        for (i = 3; i <= n; i++) {
            trm = prv + pre;
            System.out.printf("  %d  ", trm);
            prv = pre;
            pre = trm;
        }
        System.out.println();
    }
}
