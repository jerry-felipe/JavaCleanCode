import java.util.Scanner;

public class RootQuadraticEquation {

    public static void main(String[] args) {
        int a, b, c;
        double d, x1, x2;

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Calculate root of Quadratic Equation :");
        System.out.println("----------------------------------------");
        System.out.println();

        System.out.print("Input the value of a : ");
        a = sc.nextInt();
        System.out.print("Input the value of b : ");
        b = sc.nextInt();
        System.out.print("Input the value of c : ");
        c = sc.nextInt();

        d = b * b - 4 * a * c;
        if (d == 0) {
            System.out.println("Both roots are equal.");
            x1 = -b / (2.0 * a);
            x2 = x1;
            System.out.println("First Root Root1= " + x1);
            System.out.println("Second Root Root2= " + x2);
        } else if (d > 0) {
            System.out.println("Both roots are real and different");

            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);

            System.out.println("First Root Root1= " + x1);
            System.out.println("Second Root Root2= " + x2);
        } else {
            System.out.println("Roots are imaginary; No Solution.");
        }
    }
}
