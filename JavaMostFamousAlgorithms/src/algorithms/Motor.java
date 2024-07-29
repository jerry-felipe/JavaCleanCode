package algorithms;

public class Motor {

    public void acelerar() {
        // Implementación de la función de aceleración
        // ...
    }

    public int getRevoluciones() {
        int currentRPM = 0;

        // Implementación para obtener las revoluciones actuales del motor
        // ...

        return currentRPM;
    }

    public static void main(String[] args) {
        Motor motor = new Motor();

        // Ejemplo de uso
        motor.acelerar();

        int rpm = motor.getRevoluciones();
        System.out.println("Revoluciones actuales: " + rpm);
    }
}
