import java.net.Socket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.io.IOException;
import java.net.DatagramSocket;

public class TestSocket {
    public static void run() {
        try {
            Socket socket = new Socket(InetAddress.getByName("reglaboyscout.com"), 80);

            // Creating TCP client socket
            Socket client = new Socket("reglaboyscout.com", 80);

            // Creating UDP client socket
            DatagramSocket listener = new DatagramSocket(80);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
