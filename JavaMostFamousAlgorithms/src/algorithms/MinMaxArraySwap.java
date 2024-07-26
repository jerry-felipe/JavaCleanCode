public class MinMaxArraySwap {

    public void minMaxSwap(int[] input) {
        if (input.length == 0)
            return;

        int maxPos = 0;
        int minPos = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[maxPos] < input[i])
                maxPos = i;
            if (input[minPos] > input[i])
                minPos = i;
        }

        int valMax = input[maxPos];
        int valMin = input[minPos];

        input[maxPos] = valMin;
        input[minPos] = valMax;

        System.out.println(valMax); // Puedes comentar o eliminar esta línea si no necesitas imprimir el valor máximo
    }

    public void minMaxSwap2(int[] x) {
        int min = 0;
        int max = 0;

        for (int i = 1; i < x.length; i++) {
            if (x[min] > x[i])
                min = i;
            if (x[max] < x[i])
                max = i;
        }

        int temp = x[min];
        x[min] = x[max];
        x[max] = temp;
    }

    public static void main(String[] args) {
        MinMaxArraySwap solution = new MinMaxArraySwap();

        int[] input1 = { 1, 2, 3, 4, 5 };
        solution.minMaxSwap(input1);
        System.out.println(Arrays.toString(input1)); // Para verificar el resultado, imprime el arreglo

        int[] input2 = { 5, 4, 3, 2, 1 };
        solution.minMaxSwap2(input2);
        System.out.println(Arrays.toString(input2)); // Para verificar el resultado, imprime el arreglo
    }
}
