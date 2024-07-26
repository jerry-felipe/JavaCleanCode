import java.util.Scanner;

public class SparseMatrix {
    public static void main(String[] args) {
        int[][] arr1 = new int[10][10];
        int i, j, r, c;
        int ctr = 0;

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\n\nDetermine whether a matrix is a sparse matrix :\n ");
        System.out.print("----------------------------------------------------\n");
        System.out.print("Input the number of rows of the matrix: ");
        r = scanner.nextInt();
        System.out.print("Input the number of columns of the matrix: ");
        c = scanner.nextInt();
        System.out.println("Input elements in the matrix:");
        
        for (i = 0; i < r; i++) {
            for (j = 0; j < c; j++) {
                System.out.print("element - [" + i + "],[" + j + "] : ");
                arr1[i][j] = scanner.nextInt();
                if (arr1[i][j] == 0) {
                    ++ctr;
                }
            }
        }
        
        if (ctr > ((r * c) / 2)) {
            System.out.println("The given matrix is a sparse matrix.");
        } else {
            System.out.println("The given matrix is not a sparse matrix.");
        }
        
        System.out.println("There are " + ctr + " number of zeros in the matrix.\n");
        
        scanner.close();
    }
}
