import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileReader {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TextFileReader filename output1 output2 output3 ...");
            return;
        }

        // Write each command line argument to the file
        String destFilename = args[0];
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destFilename))) {
            for (int i = 1; i < args.length; i++) {
                writer.write(args[i]);
                writer.newLine();
            }
            System.out.println("Wrote args to file " + destFilename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read back the file and dump it to the console
        try (BufferedReader reader = new BufferedReader(new FileReader(destFilename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
