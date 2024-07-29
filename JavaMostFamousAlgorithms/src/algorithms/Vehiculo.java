package algorithms;

public class Vehiculo {
    private Motor m;

    public Vehiculo() {
        m = new Motor();
    }

    public int getRevolucionesMotor() {
        return m.getRevoluciones();
    }

    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo();
        System.out.println("Revoluciones del motor: " + vehiculo.getRevolucionesMotor());
    }
}

class Motor {
    public int getRevoluciones() {
        int currentRPM = 0;
        // Lógica para obtener las revoluciones del motor
        return currentRPM;
    }
}
