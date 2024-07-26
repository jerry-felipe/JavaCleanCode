import java.util.Scanner;

public class IdentityMatrix {

    public static void main(String[] args) {
        int[][] arr1 = new int[50][50];
        int i, j, r1, c1;

        Scanner input = new Scanner(System.in);

        System.out.println("\nCheck whether a Given Matrix is an Identity Matrix:");
        System.out.println("--------------------------------------------------");

        System.out.print("Input the order (2x2, 3x3, ...) of square matrix: ");
        r1 = input.nextInt();
        c1 = r1;

        System.out.println("Input elements in the matrix:");
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c1; j++) {
                System.out.print("Element - [" + i + "],[" + j + "]: ");
                arr1[i][j] = input.nextInt();
            }
        }

        System.out.println("The matrix is:");
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c1; j++)
                System.out.print(" " + arr1[i][j] + " ");
            System.out.println();
        }

        boolean isIdentity = true;
        for (i = 0; i < r1; i++) {
            for (j = 0; j < c1; j++) {
                if ((i == j && arr1[i][j] != 1) || (i != j && arr1[i][j] != 0)) {
                    isIdentity = false;
                    break;
                }
            }
            if (!isIdentity) {
                break;
            }
        }

        if (isIdentity) {
            System.out.println("The matrix is an Identity Matrix.\n");
        } else {
            System.out.println("The matrix is not an Identity Matrix.\n");
        }
    }
}
