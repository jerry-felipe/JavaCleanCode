import java.util.Scanner;

public class PuntoCoordenadas {
    public static void main(String[] args) {
        int co1, co2;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nFind the quadrant in which the coordinate point lies:");
        System.out.println("------------------------------------------------------\n\n");

        System.out.print("Input the value for X coordinate: ");
        co1 = scanner.nextInt();
        System.out.print("Input the value for Y coordinate: ");
        co2 = scanner.nextInt();

        if (co1 > 0 && co2 > 0)
            System.out.printf("The coordinate point (%d, %d) lies in the First quadrant.\n\n", co1, co2);
        else if (co1 < 0 && co2 > 0)
            System.out.printf("The coordinate point (%d, %d) lies in the Second quadrant.\n\n", co1, co2);
        else if (co1 < 0 && co2 < 0)
            System.out.printf("The coordinate point (%d, %d) lies in the Third quadrant.\n\n", co1, co2);
        else if (co1 > 0 && co2 < 0)
            System.out.printf("The coordinate point (%d, %d) lies in the Fourth quadrant.\n\n", co1, co2);
        else if (co1 == 0 && co2 == 0)
            System.out.printf("The coordinate point (%d, %d) lies at the origin.\n\n", co1, co2);
    }
}
