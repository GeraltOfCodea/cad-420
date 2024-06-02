/*Created by Ryan Norrbom 
 * Created On: 06/01/2024
 * Created for: CSD420
 * 
 * Main Class to call Java files for each module in the Advanced Java Programming Class at Bellevue
 * 
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:");
            System.out.println("1. Write data to file");
            System.out.println("2. Read data from file");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    NorrbomRyan_Module1_Write.writeData();
                    break;
                case 2:
                    NorrbomRyan_Module1_Read.readData();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}