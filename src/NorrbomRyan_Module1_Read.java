/*Created by Ryan Norrbom 
 * Created On: 06/01/2024
 * Created for: CSD420
 * ##Assignment: 1.2
 * 
 * Java class to read the files that are created in the Module 1 Write class. Reads a .dat file and displays what is in it. 
 * 
 */
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class NorrbomRyan_Module1_Read {

    public static void readData() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("NorrbomRyan_datafile.dat"))) {
            int[] intArray = new int[5];
            double[] doubleArray = new double[5];

            for (int i = 0; i < 5; i++) {
                intArray[i] = dis.readInt();
            }
            Date currentDate = new Date(dis.readLong());
            for (int i = 0; i < 5; i++) {
                doubleArray[i] = dis.readDouble();
            }

            System.out.println("Integers:");
            for (int i : intArray) {
                System.out.print(i + " ");
            }
            System.out.println("\nDate: " + currentDate);
            System.out.println("Doubles:");
            for (double d : doubleArray) {
                System.out.print(d + " ");
            }
            System.out.println("\nData read from file successfully.");
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
}