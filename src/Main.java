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
            System.out.println("0. Exit");
            System.out.println("1. Module 1: Write data to file");
            System.out.println("2. Module 1: Read data from file");
            System.out.println("3. Module 2: Recursion");
            System.out.println("4. Module 3: Array Lists");
            System.out.println("5. Module 4");
            System.out.println("6. Module 5");
            System.out.println("7. Module 6");
            System.out.println("8. Module 7");

            

            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    NorrbomRyan_Module1_Write.writeData();
                    break;
                case 2:
                    NorrbomRyan_Module1_Read.readData();
                    break;
                case 3:
                    NorrbomRyan_Module2.main(args);
                    break;
                case 4:
                    NorrbomRyan_Module3.main(args);
                    break;
                case 5:
                    NorrbomRyan_Module4.main(args);
                    break;
                case 6:
                    NorrbomRyan_Module5.main(args);
                    break;
                case 7:
                    NorrbomRyan_Module6.main(args);
                    break;
                case 8:
                    NorrbomRyan_Module7.main(args);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}