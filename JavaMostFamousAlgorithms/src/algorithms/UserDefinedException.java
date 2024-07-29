package algorithms;

public class UserDefinedException {
    public static void main(String[] args) {
        TestTemperature tempTest = new TestTemperature();
        try {
            tempTest.test();
        } catch (TempIsZeroException e) {
            System.out.println("TempIsZeroException: " + e.getMessage());
        }
    }
}

class TestTemperature {
    public void test() throws TempIsZeroException {
        Temperature temp = new Temperature();
        temp.showTemp();
    }
}

class TempIsZeroException extends Exception {
    public TempIsZeroException(String message) {
        super(message);
    }
}

class Temperature {
    private int temperature = 0;

    public void showTemp() throws TempIsZeroException {
        if (temperature == 0) {
            throw new TempIsZeroException("Zero Temperature found");
        } else {
            System.out.println("Temperature: " + temperature);
        }
    }
}
