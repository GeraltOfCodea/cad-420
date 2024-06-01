import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class NorrbomRyan_Module1_Write {

    public static void writeData() {
        Random random = new Random();
        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        for (int i = 0; i < 5; i++) {
            intArray[i] = random.nextInt(100); // Random integers between 0 and 99
            doubleArray[i] = random.nextDouble() * 100; // Random doubles between 0 and 100
        }

        Date currentDate = new Date();

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("NorrbomRyan_datafile.dat"))) {
            for (int i : intArray) {
                dos.writeInt(i);
            }
            dos.writeLong(currentDate.getTime());
            for (double d : doubleArray) {
                dos.writeDouble(d);
            }
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
